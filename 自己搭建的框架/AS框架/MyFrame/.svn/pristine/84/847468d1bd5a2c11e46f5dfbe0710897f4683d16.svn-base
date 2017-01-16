package com.alnton.myframecore.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * <网络工具类>
 * @author  王乾州
 */
public class NetworkUtil
{
    public static NetworkUtil instance;
    
    public static NetworkUtil getInstance()
    {
        if (null == instance)
        {
            instance = new NetworkUtil();
        }
        return instance;
    }
    
    /**
     * 手机网络数据类型
     */
    public String networkDataType;
    
    /**
     * 网络类型
     */
    public final String NET_TYPE_WIFI = "WIFI";
    
    public final String NET_TYPE_MOBILE = "MOBILE";
    
    public final String NET_TYPE_UNKNOWN = "unknown";
    
    public final String NET_TYPE_2G = "2G";
    
    public final String NET_TYPE_3G = "3G";
    
    public final String NET_TYPE_4G = "4G";
    
    /**
     * 判断是否有数据网络打开
     * (WIFI / 移动数据网络)
     * @param context
     * @return true open ,false close
     */
    public boolean isHaveNetwork(Context context)
    {
        boolean isConnected = false;
        ConnectivityManager connectMananger =
            (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = connectMananger.getActiveNetworkInfo();
        if (null != network)
        {
            isConnected = network.isAvailable();
        }
        return isConnected;
    }
    
    /**
     * 判断当前网络类型是WIFI还是MOBILE
     * @param context
     * @return
     */
    public String isWifiOrMobile(Context context)
    {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        
        if (null != networkInfo && networkInfo.isConnected())
        {
            String type = networkInfo.getTypeName();
            
            if ("WIFI".equalsIgnoreCase(type))
            {
                return NET_TYPE_WIFI;
            }
            else if ("MOBILE".equalsIgnoreCase(type))
            {
                return NET_TYPE_MOBILE;
            }
            return NET_TYPE_UNKNOWN;
        }
        
        return NET_TYPE_UNKNOWN;
    }
    
    /**
     * 获得当前手机类型
     * @param context
     * @return
     */
    public String getPhoneType(Context context)
    {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        int phoneType = telephonyManager.getPhoneType();
        
        switch (phoneType)
        {
            case TelephonyManager.PHONE_TYPE_CDMA:
                return "CDMA";
                
            case TelephonyManager.PHONE_TYPE_GSM:
                return "GSM";
                
            case TelephonyManager.PHONE_TYPE_NONE:
                return "NONE";
                
            case TelephonyManager.PHONE_TYPE_SIP:
                return "SIP";
                
            default:
                return "unknown";
        }
    }
    
    /**
     * 获取手机网络类型 
     *  2G 3G 4G
     * @param context
     * @return
     */
    public String isFastMobileNetwork(Context context)
    {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        switch (telephonyManager.getNetworkType())
        {
            case TelephonyManager.NETWORK_TYPE_1xRTT: // 电信2G
                networkDataType = "1xRTT";
                return NET_TYPE_2G; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_CDMA:// 电信2G
                networkDataType = "CDMA";
                return NET_TYPE_2G; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_EDGE:// 联通和移动2G
                networkDataType = "EDGE";
                return NET_TYPE_2G; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_IDEN: // 2G
                networkDataType = "IDEN";
                return NET_TYPE_2G; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_GPRS:// 2G
                networkDataType = "GPRS";
                return NET_TYPE_2G; // ~ 50-100 kbps
                
            case TelephonyManager.NETWORK_TYPE_EVDO_0:// 电信的3G
                networkDataType = "EVDO0";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_EVDO_A: // 电信的3G
                networkDataType = "EVDOA";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_HSDPA:// 联通3G
                networkDataType = "HSDPA";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPA: // 3G
                networkDataType = "HSPA";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_HSUPA:// 3G 3.5G
                networkDataType = "HSUPA";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_UMTS:// 联通3G
                networkDataType = "UMTS";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_EHRPD: // 3G
                networkDataType = "EHRPD";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_EVDO_B: // 3G
                networkDataType = "EVDOB";
                return NET_TYPE_3G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPAP: // 3G
                networkDataType = "HSPAP";
                return NET_TYPE_3G; // ~ 10-20 Mbps
                
            case TelephonyManager.NETWORK_TYPE_LTE: // 4G
                networkDataType = "LTE";
                return NET_TYPE_4G; // ~ 10+ Mbps
                
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                return "unknown";
                
            default:
                networkDataType = "TD";
                return NET_TYPE_3G; // ~ 10-20 Mbps
        }
    }
    
    
    /**
     * 获得当前MCC MNC
     * @param context
     * @return
     */
    public String getMCCMNC(Context context)
    {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getNetworkOperator();
    }
}