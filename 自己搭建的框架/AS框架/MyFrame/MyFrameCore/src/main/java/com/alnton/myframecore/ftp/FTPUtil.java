package com.alnton.myframecore.ftp;

import android.os.Handler;

import com.alnton.myframecore.application.CacheSession;
import com.alnton.myframecore.util.TelephoneUtil;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 * <断点续传下载FTP工具类>
 *
 * @author 王乾州
 */
public class FTPUtil {
    /**
     * FTP客户端
     */
    public FTPClient ftpClient;

    /**
     * 数据更新Handler
     */
    public Handler handler;

    /**
     * 缓冲区
     */
    public byte[] bytes;

    public FTPUtil(Handler handler) {
        this.handler = handler;

        ftpClient = new FTPClient();
        //设置传输超时时间为5分钟 
        ftpClient.setDataTimeout(60000 * 5);
        //连接超时为60秒
        ftpClient.setConnectTimeout(60000);

        // 设置缓冲区
        bytes = new byte[1024 * 20];

        // 设置将过程中使用到的命令输出到控制台
        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
    }

    /**
     * <上传文件到FTP服务器，支持断点续传>
     *
     * @param hostname: 主机名
     * @param port:     端口
     * @param username: 用户名
     * @param password: 密码
     * @param local     本地文件名称，绝对路径(以/开头,指定到本地存储文件的名称)
     * @param remote    远程文件路径，使用/home/directory1/subdirectory/file.ext或是
     *                  http://www.guihua.org/subdirectory/file.ext
     *                  按照Linux上的路径指定方式，支持多级目录嵌套，支持递归创建不存在的目录结构
     * @return 上传结果状态
     */
    public FTPStatus upload(String hostname, int port, String username, String password, String local, String remote)
            throws IOException {
        try {
            FTPStatus result;
            /**
             * 连接FTP服务器并登陆
             */
            ftpClient.connect(hostname, port);
            if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                if (ftpClient.login(username, password)) {
                    // 设置LocalActiveMode(主动模式)传输
                    // ftpClient.enterLocalActiveMode();

                    // 设置PassiveMode(被动模式)传输
                    ftpClient.enterLocalPassiveMode();

                    // 设置以二进制流的方式传输
                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                    ftpClient.setControlEncoding("UTF-8");
                    // 对远程目录的处理
                    String remoteFileName = remote;
                    if (remote.contains("/")) {
                        remoteFileName = remote.substring(remote.lastIndexOf("/") + 1);
                        // 创建服务器远程目录结构，创建失败直接返回
                        if (CreateDirecroty(remote) == FTPStatus.Create_Directory_Fail) {
                            return FTPStatus.Create_Directory_Fail;
                        }
                    }

                    // 检查远程是否存在文件
                    FTPFile[] files = ftpClient.listFiles(new String(remoteFileName.getBytes("UTF-8"), "iso-8859-1"));
                    if (files.length == 1) {
                        /**
                         * 文件存在，断点续传
                         */
                        long remoteSize = files[0].getSize();
                        File f = new File(local);
                        long localSize = f.length();
                        if (remoteSize == localSize) {
                            return FTPStatus.File_Exits;
                        } else if (remoteSize > localSize) {
                            return FTPStatus.Remote_Bigger_Local;
                        }

                        // 尝试移动文件内读取指针,实现断点续传
                        result = uploadFile(remoteFileName, f, remoteSize);

                        // 如果断点续传没有成功，则删除服务器上文件，重新上传
                        if (result == FTPStatus.Upload_From_Break_Failed) {
                            if (!ftpClient.deleteFile(remoteFileName)) {
                                return FTPStatus.Delete_Remote_Faild;
                            }
                            result = uploadFile(remoteFileName, f, 0);
                        }
                    } else {
                        /**
                         * 文件不存在，新上传
                         */
                        result = uploadFile(remoteFileName, new File(local), 0);
                    }
                    CacheSession.getInstance().isBack = false;
                    return result;
                }
                return FTPStatus.Login_Fail;
            }
            return FTPStatus.Connect_Fail;
        } finally {
            disconnect();
        }
    }

    /**
     * <递归创建远程服务器目录>
     *
     * @param remote 远程服务器文件绝对路径
     * @return 目录创建是否成功
     * @throws IOException
     */
    public FTPStatus CreateDirecroty(String remote)
            throws IOException {
        String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
        if (!directory.equalsIgnoreCase("/")
                && !ftpClient.changeWorkingDirectory(new String(directory.getBytes("UTF-8"), "iso-8859-1"))) {
            // 如果远程目录不存在，则递归创建远程服务器目录
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("UTF-8"), "iso-8859-1");
                if (!ftpClient.changeWorkingDirectory(subDirectory)) {
                    if (ftpClient.makeDirectory(subDirectory)) {
                        ftpClient.changeWorkingDirectory(subDirectory);
                    } else {
                        return FTPStatus.Create_Directory_Fail;
                    }
                }

                start = end + 1;
                end = directory.indexOf("/", start);

                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return FTPStatus.Create_Directory_Success;
    }

    /**
     * <上传文件到服务器,新上传和断点续传>
     *
     * @param remoteFile 远程文件名，在上传之前已经将服务器工作目录做了改变
     * @param localFile  本地文件File句柄，绝对路径
     * @param remoteSize 需要显示的处理进度步进值
     * @return
     * @throws IOException
     */
    public FTPStatus uploadFile(String remoteFile, File localFile, long remoteSize)
            throws IOException {
        FTPStatus status;
        // 显示进度的上传
        long step = localFile.length() / 100;
        long process = 0;
        long localreadbytes = 0L;
        RandomAccessFile raf = new RandomAccessFile(localFile, "r");
        OutputStream out = ftpClient.appendFileStream(new String(remoteFile.getBytes("UTF-8"), "iso-8859-1"));
        // 断点续传
        if (remoteSize > 0) {
            ftpClient.setRestartOffset(remoteSize);
            process = remoteSize / step;
            raf.seek(remoteSize);
            localreadbytes = remoteSize;
        }
        int c;
        while ((c = raf.read(bytes)) != -1 && !CacheSession.getInstance().isBack) {
            out.write(bytes, 0, c);
            localreadbytes += c;
            if (localreadbytes / step != process) {
                process = localreadbytes / step;
                if (null != handler) {
                    handler.sendEmptyMessage((int) process);
                }
            }
        }
        out.flush();
        raf.close();
        out.close();
        boolean result = ftpClient.completePendingCommand();
        if (remoteSize > 0) {
            status = result ? FTPStatus.Upload_From_Break_Success : FTPStatus.Upload_From_Break_Failed;
        } else {
            status = result ? FTPStatus.Upload_New_File_Success : FTPStatus.Upload_New_File_Failed;
        }
        return status;
    }

    /**
     * <从FTP服务器上下载文件,支持断点续传，上传百分比汇报>
     *
     * @param local  本地文件名称，绝对路径(以/开头,指定到本地存储文件的名称)
     * @param remote 远程文件路径，使用/home/directory1/subdirectory/file.ext或是
     *               http://www.guihua.org/subdirectory/file.ext
     *               按照Linux上的路径指定方式，支持多级目录嵌套，支持递归创建不存在的目录结构
     * @return 下载的状态
     * @throws IOException
     */
    public FTPStatus download(String hostname, int port, String username, String password, String remote, String local)
            throws IOException {
        try {
            FTPStatus result;
            /**
             * 连接FTP服务器并登陆
             */
            ftpClient.connect(hostname, port);
            if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                if (ftpClient.login(username, password)) {
                    // 设置被动模式
                    ftpClient.enterLocalPassiveMode();
                    // 设置以二进制方式传输
                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                    // 检查远程文件是否存在
                    FTPFile[] files = ftpClient.listFiles(new String(remote.getBytes("UTF-8"), "iso-8859-1"));
                    if (files.length != 1) {
                        return FTPStatus.Remote_File_Noexist;
                    }
                    long lRemoteSize = files[0].getSize();
                    if (lRemoteSize > TelephoneUtil.getInstance().getROMAvailableSize()) {
                        return FTPStatus.SD_MEMERY_NOT_ENOUGH;
                    }
                    File f = new File(local);

                    if (f.exists()) {
                        /**
                         * 本地存在文件，进行断点下载
                         */
                        long localSize = f.length();
                        // 判断本地文件大小是否大于远程文件大小
                        if (localSize >= lRemoteSize) {
                            return FTPStatus.Local_Bigger_Remote;
                        } else {
                            // 进行断点续传，并记录状态
                            FileOutputStream out = new FileOutputStream(f, true);
                            ftpClient.setRestartOffset(localSize);
                            InputStream in =
                                    ftpClient.retrieveFileStream(new String(remote.getBytes("UTF-8"), "iso-8859-1"));
                            long step = lRemoteSize / 100;
                            long process = localSize / step;
                            int c;
                            while ((c = in.read(bytes)) != -1 && !CacheSession.getInstance().isBack) {
                                out.write(bytes, 0, c);
                                localSize += c;
                                long nowProcess = localSize / step;
                                if (nowProcess > process) {
                                    process = nowProcess;
                                    if (null != handler) {
                                        handler.sendEmptyMessage((int) process);
                                    }
                                }
                            }
                            in.close();
                            out.close();
                            boolean isDo = ftpClient.completePendingCommand();
                            if (isDo) {
                                result = FTPStatus.Download_From_Break_Success;
                            } else {
                                result = FTPStatus.Download_From_Break_Failed;
                            }
                        }
                    } else {
                        /**
                         * 本地不存在文件，进行新下载
                         */
                        OutputStream out = new FileOutputStream(f);
                        InputStream in =
                                ftpClient.retrieveFileStream(new String(remote.getBytes("UTF-8"), "iso-8859-1"));
                        long step = lRemoteSize / 100;
                        long process = 0;
                        long localSize = 0L;
                        int c;
                        while ((c = in.read(bytes)) != -1 && !CacheSession.getInstance().isBack) {
                            out.write(bytes, 0, c);
                            localSize += c;
                            long nowProcess = localSize / step;
                            if (nowProcess > process) {
                                process = nowProcess;
                                if (null != handler) {
                                    handler.sendEmptyMessage((int) process);
                                }
                            }
                        }
                        in.close();
                        out.close();
                        boolean upNewStatus = ftpClient.completePendingCommand();
                        if (upNewStatus) {
                            result = FTPStatus.Download_New_Success;
                        } else {
                            result = FTPStatus.Download_New_Failed;
                        }
                    }
                    CacheSession.getInstance().isBack = false;
                    return result;
                }
                return FTPStatus.Login_Fail;
            }
            return FTPStatus.Connect_Fail;
        } finally {
            disconnect();
        }
    }

    /**
     * 断开与远程服务器的连接
     *
     * @throws IOException
     */
    private void disconnect()
            throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.disconnect();
        }
    }
}