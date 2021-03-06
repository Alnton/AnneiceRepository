package com.alnton.myframecore.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Looper;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,由该类来接管程序,并记录发送错误报告.
 * @author 王乾州
 */
public class CrashHandler implements UncaughtExceptionHandler
{
    /**
     * CrashHandler实例
     */
    private static CrashHandler crashHandler;
    
    /**
     * 系统默认的UncaughtException处理类
     */
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    
    /**
     * 程序的Context对象
     */
    private Context mContext;
    
    /**
     * log日志保存的路径
     */
    private String logPath;
    
    /**
     * 上传日志服务器地址
     */
    private String uploadURL;
    
    /**
     * SharedPreferencesUtil工具类
     */
    private SharedPreferencesUtil sharedPreferencesUtil;
    
    /**
     * 用来存储设备信息和异常信息
     */
    private Map<String, String> info = new HashMap<String, String>();
    
    /**
     * 用于格式化日期,作为日志文件名的一部分
     */
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    
    public static CrashHandler getInstance()
    {
        if (null == crashHandler)
        {
            crashHandler = new CrashHandler();
        }
        return crashHandler;
    }
    
    /**
     * 初始化
     * 
     * @param context
     */
    public void init(Context context, String logPath, String uploadURL)
    {
        mContext = context;
        
        this.uploadURL = uploadURL;
        
        sharedPreferencesUtil = new SharedPreferencesUtil(context, 0);
        
        this.logPath = logPath;
        
        // 获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        
        // 设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    
    /**
     * 当UncaughtException发生时会转入该重写的方法来处理
     */
    public void uncaughtException(Thread thread, Throwable ex)
    {
        if (!handleException(ex) && null != mDefaultHandler)
        {
            // 如果自定义的没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        }
        else
        {
            try
            {
                // 如果处理了，让程序继续运行3秒再退出，保证文件保存并上传到服务器
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            // 退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
    
    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     * 
     * @param ex
     *            异常信息
     * @return true 如果处理了该异常信息;否则返回false.
     */
    public boolean handleException(Throwable ex)
    {
        if (null == ex)
            return false;
        new Thread()
        {
            public void run()
            {
                Looper.prepare();
                Toast.makeText(mContext, "很抱歉,程序出现异常,即将退出!", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();
        // 收集设备参数信息
        collectDeviceInfo(mContext);
        // 保存日志文件
        String fileName = saveCrashInfo2File(ex);
        
        if (null != fileName)
        {
            final File uploadFile = new File(logPath + fileName);
            if (null != uploadFile && uploadFile.exists()
                && sharedPreferencesUtil.getBoolean(sharedPreferencesUtil.SHAREDPREFERENCES_UPLOAD, true))
            {
                new Thread()
                {
                    public void run()
                    {
                        Looper.prepare();
                        uploadExcption(uploadFile);
                        Looper.loop();
                    }
                }.start();
            }
        }
        return true;
    }
    
    /**
     * 收集设备参数信息
     * 
     * @param context
     */
    public void collectDeviceInfo(Context context)
    {
        try
        {
            // 获得包管理器
            PackageManager pm = context.getPackageManager();
            // 得到该应用的信息，即主Activity
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (pi != null)
            {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                info.put("versionName", versionName);
                info.put("versionCode", versionCode);
            }
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        
        Field[] fields = Build.class.getDeclaredFields();// 反射机制
        for (Field field : fields)
        {
            try
            {
                field.setAccessible(true);
                info.put(field.getName(), field.get("").toString());
            }
            catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private String saveCrashInfo2File(Throwable ex)
    {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : info.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + "=" + value + "\r\n");
        }
        Writer writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        ex.printStackTrace(pw);
        Throwable cause = ex.getCause();
        // 循环着把所有的异常信息写入writer中
        while (cause != null)
        {
            cause.printStackTrace(pw);
            cause = cause.getCause();
        }
        pw.close();// 记得关闭
        String result = writer.toString();
        sb.append(result);
        // 保存文件
        long timetamp = System.currentTimeMillis();
        String time = format.format(new Date());
        String fileName = "crash-" + time + "-" + timetamp + ".log";
        String sdPath = TelephoneUtil.getInstance().getSDPath();
        if (null != sdPath && !"".equals(sdPath.trim()))
        {
            try
            {
                File dir = FileUtil.getInstance().createDirectory(logPath);
                FileOutputStream fos =
                    new FileOutputStream(FileUtil.getInstance().createNewFile(dir.getAbsolutePath() + File.separator
                        + fileName));
                fos.write(sb.toString().getBytes());
                fos.close();
                return fileName;
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    /**
     * <上传系统异常日志到服务器>
     */
    private void uploadExcption(File file)
    {
//        JsonRequestParams params = new JsonRequestParams();
//        params.put("LoginKey", sharedPreferencesUtil.getString("key_login", "1"));
//        params.put("softwareId", "ias");
//        params.put("imsi", TelephoneUtil.getInstance().getIMSI(mContext));
//        params.put("imei", TelephoneUtil.getInstance().getIMEI(mContext));
//        params.put("phone_version", Build.MODEL);
//        params.put("system_version", MyFrameCoreTools.getInstance().getVersionName(mContext));
//        try
//        {
//            params.put(file.getName(), file);
//        }
//        catch (FileNotFoundException e1)
//        {
//            e1.printStackTrace();
//        }
    }
}