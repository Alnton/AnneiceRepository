package com.alnton.myframe.application;

import android.app.Application;

/**
 * <缓存程序中的数据>
 * @author  王乾州
 */
public class CacheSession extends Application
{
    private static CacheSession instance;
    
    public static CacheSession getInstance()
    {
        if (null == instance)
        {
            instance = new CacheSession();
        }
        return instance;
    }
    
    /**
     * 订单编号
     */
    public String orderCode;
}