package com.alnton.myFrameCore.service;

import android.content.Context;
import android.os.Handler;

import com.alnton.myFrameCore.entity.LocationInfo;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;

/**
 * AMapV2地图中GPS定位
 */
public class LocationGPSUtils implements AMapLocationListener, Runnable
{
    private AMapLocationClient locationClient = null;
    
    private AMapLocationClientOption locationOption = null;
    
    /**
     * 用于判断定位超时
     */
    private AMapLocation aMapLocation;
    
    /**
     * 超时的Handler
     */
    private Handler timeOutHandler = new Handler();
    
    /**
     * GPS定位成功
     */
    public static final int LOCATION_GPS_SUCCESS = 2;
    
    /**
     * 获取地理位置失败
     */
    public static final int LOCATION_FAILURE = 0;
    
    private Handler mHandler;
    
    public LocationGPSUtils(Context context)
    {
        locationClient = new AMapLocationClient(context);
        locationOption = new AMapLocationClientOption();
        // 设置定位模式为GPS定位
        locationOption.setLocationMode(AMapLocationMode.Device_Sensors);
        //设置为持续定位
        locationOption.setOnceLocation(false);
        // 设置定位间隔
        locationOption.setInterval(1000l);
        // 设置定位监听
        locationClient.setLocationListener(this);
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
    }
    
    public void requestLocation(Handler handler)
    {
        this.mHandler = handler;
        
        // 启动定位
        locationClient.startLocation();
        
        // 设置超过12秒还没有定位到就停止定位
        timeOutHandler.postDelayed(this, 12000);
    }
    
    /**
     * 定位回调方法
     */
    @Override
    public void onLocationChanged(AMapLocation location)
    {
        try
        {
            LocationInfo locationInfo = new LocationInfo();
            
            if (null != location && 0 == location.getErrorCode())
            {
                // 判断超时机制
                this.aMapLocation = location;
                
                // 定位成功
                locationInfo.setLatitude(location.getLatitude());
                locationInfo.setLongitude(location.getLongitude());
                locationInfo.setAccuracy(location.getAccuracy());
                locationInfo.setProvider(location.getProvider());
                locationInfo.setTime(location.getTime());
                locationInfo.setSpeed(location.getSpeed());
                locationInfo.setBearing(location.getBearing());
                locationInfo.setSatellites(location.getSatellites());
                
                mHandler.obtainMessage(LOCATION_GPS_SUCCESS, locationInfo).sendToTarget();
            }
            else
            {
                // 定位失败
                locationInfo.setErrorCode(location.getErrorCode());
                locationInfo.setErrorInfo(location.getErrorInfo());
                locationInfo.setErrorLocationDetail(location.getLocationDetail());
                
                mHandler.obtainMessage(LOCATION_FAILURE, locationInfo).sendToTarget();
            }
        }
        finally
        {
            // 销毁掉定位
            onDestory();
        }
    }
    
    @Override
    public void run()
    {
        if (null == aMapLocation)
        {
            mHandler.obtainMessage(LOCATION_FAILURE, null).sendToTarget();
            
            // 销毁掉定位
            onDestory();
        }
    }
    
    public void onDestory()
    {
        if (null != locationClient)
        {
            // 停止定位
            locationClient.stopLocation();
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }
}