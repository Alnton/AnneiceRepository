package com.alnton.myFrameCore.application;

import java.util.ArrayList;

import android.app.Application;
import android.graphics.Bitmap;

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
     * Intent 之间传递的Bitmap对象
     */
    public Bitmap bitmap;
    
    /**
     * Bitmap集合
     */
    public ArrayList<Bitmap> bitmapArrayList = new ArrayList<Bitmap>();
    
    /**
     * FTP下载上传，是否点击返回按钮
     */
    public Boolean isBack = false;
}