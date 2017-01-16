package com.alnton.myframe.util.updateSoft;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.RemoteViews;

import com.alnton.myframe.R;
import com.alnton.myframe.config.Config.FilePathConfig;
import com.alnton.myframe.ui.main.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 版本更新下载APK服务
 *
 * @author 王乾州
 * @createon 2016-9-22
 */
public class DownloadApkService extends Service {
    /**
     * 下载取消的广播
     */
    private String ACTION_CANCEL_DOWNLOAD_APK = "action_cancel_download_apk";

    /**
     * 下载暂停的广播
     */
    private String ACTION_PAUSE_DOWNLOAD_APK = "action_pause_download_apk";

    /**
     * 下载成功
     */
    private final int DOWNLOAD_SUCCESS = 12;

    /**
     * 下载取消
     */
    private final int DOWNLOAD_CANCEL = 11;

    /**
     * 下载出错
     */
    private final int DOWNLOAD_ERROR = 14;

    /**
     * 下载进度
     */
    private final int SET_PROGRESS = 13;

    /**
     * 下载通知ID
     */
    private static final int NOTIFY_ID = 0;

    /**
     * 下载进度值
     */
    private int progress;

    /**
     * 下载最新进度值
     */
    private int lastRate;

    /**
     * 通知
     */
    private Notification mNotification;

    /**
     * 通知管理器
     */
    private NotificationManager mNotificationManager;

    /**
     * 下载是否取消
     */
    private boolean canceled;

    /**
     * 下载返回结果接口
     */
    private ICallbackResult callback;

    /**
     * 下载线程
     */
    private Thread downLoadThread;

    /**
     * 下载绑定服务
     */
    private DownloadBinder binder;

    /**
     * 下载服务是否关闭
     */
    private boolean serviceIsDestroy = false;

    /**
     * apk名称,apk地址
     */
    private String apkName, apkUrl;

    /**
     * 应用程序上下文
     */
    private Context mContext = this;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DOWNLOAD_SUCCESS:
                    /**
                     * 下载成功
                     */
                    mNotificationManager.cancel(NOTIFY_ID);
                    installApk();
                    break;

                case DOWNLOAD_CANCEL:
                    /**
                     * 下载取消
                     */
                    mNotificationManager.cancel(NOTIFY_ID);
                    break;

                case DOWNLOAD_ERROR:
                    /**
                     * 下载出错
                     */
                    mNotificationManager.cancel(NOTIFY_ID);
                    break;

                case SET_PROGRESS:
                    /**
                     * 下载进度
                     */
                    int rate = msg.arg1;
                    if (rate < 100) {
                        RemoteViews contentview = mNotification.contentView;
                        contentview.setTextViewText(R.id.tv_progress, rate + "%");
                        contentview.setProgressBar(R.id.progressbar, 100, rate, false);
                    } else {
                        // 下载完毕后变换通知形式
                        mNotification.flags = Notification.FLAG_AUTO_CANCEL;
                        mNotification.contentView = null;
                        Intent intent = new Intent(mContext, MainActivity.class);
                        // 告知已完成
                        intent.putExtra("completed", "yes");
                        // 更新参数,注意flags要使用FLAG_UPDATE_CURRENT
                        PendingIntent contentIntent =
                                PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                        mNotification.contentIntent = contentIntent;
                        mNotification.tickerText = "文件已下载完毕";
                        // 下载服务关闭
                        serviceIsDestroy = true;
                        stopSelf();
                    }
                    mNotificationManager.notify(NOTIFY_ID, mNotification);
                    break;
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        binder = new DownloadBinder();
        mNotificationManager = (NotificationManager) getSystemService(android.content.Context.NOTIFICATION_SERVICE);

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_CANCEL_DOWNLOAD_APK);
        filter.addAction(ACTION_PAUSE_DOWNLOAD_APK);
        registerReceiver(onclickCancelListener, filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public class DownloadBinder extends Binder {
        public void start(String apkName, String apkUrl) {
            DownloadApkService.this.apkName = apkName;
            DownloadApkService.this.apkUrl = apkUrl;

            if (downLoadThread == null || !downLoadThread.isAlive()) {
                progress = 0;
                setUpNotification();
                new Thread() {
                    public void run() {
                        startDownload();
                    }

                    ;
                }.start();
            }
        }

        public void cancel() {
            canceled = true;
        }

        public int getProgress() {
            return progress;
        }

        public boolean isCanceled() {
            return canceled;
        }

        public boolean serviceIsDestroy() {
            return serviceIsDestroy;
        }

        public void cancelNotification() {
            mHandler.sendEmptyMessage(DOWNLOAD_CANCEL);
        }

        public void addCallback(ICallbackResult callback) {
            DownloadApkService.this.callback = callback;
        }
    }

    private void startDownload() {
        canceled = false;
        downloadApk();
    }

    BroadcastReceiver onclickCancelListener = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_CANCEL_DOWNLOAD_APK)) {
                mNotificationManager.cancel(NOTIFY_ID);
                binder.cancel();
                binder.cancelNotification();
                if (binder != null && binder.isCanceled()) {
                    stopSelf();
                }
                callback.OnBackResult("cancel");
            } else if (intent.getAction().equals(ACTION_PAUSE_DOWNLOAD_APK)) {
                callback.OnBackResult("cancel");
            }
        }
    };

    /**
     * 创建通知
     */
    private void setUpNotification() {
        int icon = R.mipmap.ic_launcher;
        CharSequence tickerText = "开始下载";
        long when = System.currentTimeMillis();
        mNotification = new Notification(icon, tickerText, when);
        // 放置在"正在运行"栏目中
        mNotification.flags = Notification.FLAG_ONGOING_EVENT;

        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.view_download_notification);
        contentView.setTextColor(R.id.name, 0xffffffff);
        contentView.setTextViewText(R.id.name, apkName + " 正在下载...");
        // 指定个性化视图
        mNotification.contentView = contentView;

        Intent btnCancelIntent = new Intent(ACTION_CANCEL_DOWNLOAD_APK);
        PendingIntent pendButtonIntent = PendingIntent.getBroadcast(this, 0, btnCancelIntent, 0);
        contentView.setOnClickPendingIntent(R.id.ivDelete, pendButtonIntent);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 指定内容意图
        mNotification.contentIntent = contentIntent;
        mNotificationManager.notify(NOTIFY_ID, mNotification);
    }

    private void downloadApk() {
        downLoadThread = new Thread(mdownApkRunnable);
        downLoadThread.start();
    }

    /**
     * 安装apk
     */
    private void installApk() {
        File apkfile = new File(FilePathConfig.apkFileDirectory + apkName);
        if (!apkfile.exists()) {
            return;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
        mContext.startActivity(i);
        callback.OnBackResult("finish");
    }

    private Runnable mdownApkRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(apkUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setUseCaches(true);
                conn.setConnectTimeout(2 * 1000);
                conn.setRequestMethod("GET");
                long totalLenth = (long) conn.getContentLength();

                File file = new File(FilePathConfig.apkFileDirectory);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File fileApk = new File(FilePathConfig.apkFileDirectory + apkName);
                if (!fileApk.exists()) {
                    fileApk.createNewFile();
                }
                if (null != fileApk && fileApk.length() < totalLenth) {
                    fileApk.delete();
                    fileApk.createNewFile();
                }
                if (conn.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                    return;
                }

                InputStream in = conn.getInputStream();
                FileOutputStream fileOut = new FileOutputStream(fileApk);
                byte[] buffer = new byte[1024];
                int length = -1;
                try {
                    while ((length = in.read(buffer)) != -1 && !canceled) {
                        progress = (int) (((float) fileApk.length() / totalLenth) * 100);
                        // 更新进度
                        Message msg = mHandler.obtainMessage();
                        msg.what = SET_PROGRESS;
                        msg.arg1 = progress;
                        if (progress >= lastRate + 1) {
                            mHandler.sendMessage(msg);
                            lastRate = progress;
                            if (callback != null)
                                callback.OnBackResult(progress);
                        }
                        fileOut.write(buffer, 0, length);
                    }
                    if (canceled) {
                        Message msgDownloadCancel = new Message();
                        msgDownloadCancel.what = DOWNLOAD_CANCEL;
                        mHandler.sendMessage(msgDownloadCancel);
                        return;
                    }
                    mHandler.sendEmptyMessage(DOWNLOAD_SUCCESS);
                    // 下载完了，cancelled也要设置
                    canceled = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Message msgError = new Message();
                    msgError.what = DOWNLOAD_ERROR;
                    mHandler.sendMessage(msgError);
                } finally {
                    if (null != in) {
                        in.close();
                    }
                    if (null != conn) {
                        conn.disconnect();
                    }
                    if (null != fileOut) {
                        fileOut.flush();
                        fileOut.close();
                    }
                }

            } catch (Exception e) {
                Message msgError = new Message();
                msgError.what = DOWNLOAD_ERROR;
                mHandler.sendMessage(msgError);
            }
        }
    };
}