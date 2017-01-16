package com.alnton.myFrameCore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * 手机，电话相关工具类
 * @author 王乾州
 */
public class TelephoneUtil
{
    public static TelephoneUtil instance;
    
    private DecimalFormat df = new DecimalFormat("######0.0");
    
    public static TelephoneUtil getInstance()
    {
        if (null == instance)
        {
            instance = new TelephoneUtil();
        }
        return instance;
    }
    
    /**
     * <调用系统意图打电话>
     */
    public void callPhone(Context context, String phoneNumber)
    {
        
        Intent phoneIntent = new Intent("android.intent.action.CALL",
        
        Uri.parse("tel:" + phoneNumber));
        
        //启动
        context.startActivity(phoneIntent);
    }
    
    /**
     * 判断GPS是否开启
     */
    public boolean isGPSAvailable(Context context)
    {
        LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
    
    /**
     * <获取Android 采用的SDK版本号>
     */
    public int getSDKCode()
    {
        return Build.VERSION.SDK_INT;
    }
    
    /**
     * <获取Android 采用的SDK版本名字>
     */
    public String getSDKName()
    {
        return Build.VERSION.RELEASE;
    }
    
    /**
     * 获取单一应用程序内存最大大小限制
     * @param context
     * @return Unit KB
     */
    public int getCacheSize(Context context)
    {
        return 1024 * ((ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
    }
    
    /**
     * <获取设备的型号>
     */
    public String getModelName()
    {
        return Build.MODEL;
    }
    
    /**
     * <获取手机的IMEI>
     */
    public String getIMEI(Context context)
    {
        String str = ((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        if (null == str)
            str = "";
        return str;
    }
    
    /**
     * <获取手机的IMSI>
     */
    public String getIMSI(Context context)
    {
        String str = ((TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
        if (null == str)
            str = "";
        return str;
    }
    
    /**
     * <获取手机的MAC地址>
     */
    public String getMacAddress(Context context)
    {
        return ((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getMacAddress();
    }
    
    /**
     * <获取手机的IP地址>
     */
    public String getIPAddress(Context context)
    {
        int ip = ((WifiManager)context.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getIpAddress();
        
        return (ip & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + (ip >> 24 & 0xFF);
    }
    
    /**
     * <获取手机当前采用的语言>
     */
    public String getPhoneLanguage()
    {
        String str = Locale.getDefault().getLanguage();
        if (null == str)
            str = "";
        return str;
    }
    
    /** 
     * <判断sdcard是否存在，并获取静态路径> 
     */
    public String getSDPath()
    {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            //获取SDCard目录,2.2的时候为:/mnt/sdcard  2.1的时候为：/sdcard，所以使用静态方法得到路径会好一点。 
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }
    
    /**
     * 获取手机ROM内存总大小
     * @param context
     * @return
     */
    public String getROMTotalSize(Context context)
    {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockCount = stat.getBlockCount();
        long blockSize = stat.getBlockSize();
        return df.format((double)blockCount * blockSize / (1024 * 1024 * 1024)) + "GB";
    }
    
    /**
     * 获取手机ROM可用的内存大小  
     * 单位为：B
     */
    public long getROMAvailableSize()
    {
        File path = Environment.getDataDirectory();
        if (null != path)
        {
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long availableBlocks = stat.getAvailableBlocks();
            
            return availableBlocks * blockSize;
        }
        return 0;
    }
    
    /**
     * 获取手机RAM总大小
     */
    public String getRAMTotalSize(Context context)
    {
        // 系统内存信息文件
        String str1 = "/proc/meminfo";
        String str2;
        String[] arrayOfString;
        double initial_memory = 0.0;
        try
        {
            FileReader localFileReader = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
            // 读取meminfo第一行，系统总内存大小
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            // 获得系统总内存，单位是KB，乘以1024转换为Byte
            initial_memory = Double.valueOf(arrayOfString[1]);
            localBufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return df.format(initial_memory / (1024 * 1024)) + "GB";
    }
    
    /**
     * 获取手机RAM可用的大小
     */
    public String getRAMAvailableSize(Context context)
    {
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        MemoryInfo mi = new MemoryInfo();
        am.getMemoryInfo(mi);
        return df.format((double)mi.availMem / (1024 * 1024 * 1024)) + "GB";
    }
    
    /**
     * 获得SD卡总大小 
     * 单位：B
     * @return
     */
    public long getSDTotalSize()
    {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return blockSize * totalBlocks;
    }
    
    /**
     * 获得sd卡剩余容量，即可用大小
     * 单位：B
     * @return
     */
    public long getSDAvailableSize()
    {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return blockSize * availableBlocks;
    }
    
    /**
     * 检测软键盘是否弹出，如果弹出则关闭
     * @param context： 上下文
     */
    @SuppressLint("NewApi")
    public void closeKeyboard(Activity context)
    {
        Rect r = new Rect();
        //获取当前界面可视部分
        context.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
        //获取屏幕的高度
        int screenHeight = context.getWindow().getDecorView().getRootView().getHeight();
        //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
        int heightDifference = screenHeight - r.bottom;
        if (heightDifference > 0)
        {
            InputMethodManager inputMethodManager =
                (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    
    /**
     * 设置窗体背景变黑
     * @param bgAlpha 对话框弹出时设置0.5f  关闭时候设置1f
     */
    public void backgroundAlpha(Activity context, float bgAlpha)
    {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().setAttributes(lp);
    }
}