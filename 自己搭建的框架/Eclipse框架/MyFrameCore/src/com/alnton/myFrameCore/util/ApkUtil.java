package com.alnton.myFrameCore.util;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/**
 * 获取手机上apk文件信息类，主要是判断是否安装在手机上了，安装的版本比较现有apk版本信息
 * 王乾州
 */
public class ApkUtil
{
    private static ApkUtil instance;
    
    private static Context context;
    
    /**
     * 表示已经安装，且跟现在这个apk文件是一个版本
     */
    private static int INSTALLED = 0;
    
    /**
     * 表示未安装
     */
    private static int UNINSTALLED = 1;
    
    /**
     * 表示已经安装，版本比现在这个版本要低，可以点击按钮更新
     */
    private static int INSTALLED_UPDATE = 2;
    
    public static ApkUtil getInstance(Context context)
    {
        if (null == instance)
        {
            instance = new ApkUtil();
            ApkUtil.context = context;
        }
        return instance;
    }
    
    /**
     * 得到某个apk文件的包名
     */
    public String getAPKPackageName(File file)
    {
        String packageName = null;
        if (null != file && file.isFile() && file.exists())
        {
            String fileName = file.getName();
            String apk_path = null;
            if (fileName.toLowerCase().endsWith(".apk"))
            {
                // apk文件的绝对路径
                apk_path = file.getAbsolutePath();
                PackageManager pm = context.getPackageManager();
                PackageInfo packageInfo = pm.getPackageArchiveInfo(apk_path, PackageManager.GET_ACTIVITIES);
                ApplicationInfo appInfo = packageInfo.applicationInfo;
                
                /* 获取apk的图标 */
                appInfo.sourceDir = apk_path;
                appInfo.publicSourceDir = apk_path;
                Drawable apk_icon = appInfo.loadIcon(pm);
                /* 得到包名 */
                packageName = packageInfo.packageName;
                /* apk的版本名称 String */
                String versionName = packageInfo.versionName;
                /* apk的版本号码 int */
                int versionCode = packageInfo.versionCode;
            }
        }
        return packageName;
    }
    
    /**
     * 得到某个apk文件的版本号
     */
    public int getAPKVersionCode(File file)
    {
        int VersionCode = 0;
        if (null != file && file.isFile() && file.exists())
        {
            String fileName = file.getName();
            String apk_path = null;
            if (fileName.toLowerCase().endsWith(".apk"))
            {
                // apk文件的绝对路径
                apk_path = file.getAbsolutePath();
                PackageManager pm = context.getPackageManager();
                PackageInfo packageInfo = pm.getPackageArchiveInfo(apk_path, PackageManager.GET_ACTIVITIES);
                ApplicationInfo appInfo = packageInfo.applicationInfo;
                
                /* 获取apk的图标 */
                appInfo.sourceDir = apk_path;
                appInfo.publicSourceDir = apk_path;
                Drawable apk_icon = appInfo.loadIcon(pm);
                /* 得到包名 */
                String packageName = packageInfo.packageName;
                /* apk的版本名称 String */
                String versionName = packageInfo.versionName;
                /* apk的版本号码 int */
                VersionCode = packageInfo.versionCode;
            }
        }
        return VersionCode;
    }
    
    /**
     * 获取APK文件的versioncode
     */
    public int getApkVersionCode(Context context, String filePath)
    {
        
        int code = 0;
        try
        {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageArchiveInfo(filePath, PackageManager.GET_ACTIVITIES);
            
            code = packageInfo.versionCode;
        }
        catch (Exception e)
        {
            code = 0;
        }
        return code;
        
    }
    
    /**
     * 获取APK文件的versionName
     */
    public String getApkVersionName(Context context, String filePath)
    {
        String code = null;
        try
        {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageArchiveInfo(filePath, PackageManager.GET_ACTIVITIES);
            
            code = packageInfo.versionName;
        }
        catch (Exception e)
        {
            code = null;
        }
        return code;
    }
    
    /*
     * 判断该应用是否在手机上已经安装过，有以下集中情况出现 
     * 1.未安装，这个时候按钮应该是“安装”点击按钮进行安装
     * 2.已安装，按钮显示“已安装” 可以卸载该应用 
     * 3.已安装，但是版本有更新，按钮显示“更新” 点击按钮就安装应用 
     */
    /**
     * 判断该应用在手机中的安装情况
     * @param pm                   PackageManager  
     * @param packageName          要判断应用的包名
     * @param versionCode          要判断应用的版本号
     */
    public int installType(PackageManager pm, String packageName, int versionCode)
    {
        List<PackageInfo> pakageinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (PackageInfo pi : pakageinfos)
        {
            String pi_packageName = pi.packageName;
            int pi_versionCode = pi.versionCode;
            //如果这个包名在系统已经安装过的应用中存在
            if (packageName.endsWith(pi_packageName))
            {
                if (versionCode == pi_versionCode)
                {
                    return INSTALLED;
                }
                else if (versionCode > pi_versionCode)
                {
                    return INSTALLED_UPDATE;
                }
            }
        }
        return UNINSTALLED;
    }
    
}