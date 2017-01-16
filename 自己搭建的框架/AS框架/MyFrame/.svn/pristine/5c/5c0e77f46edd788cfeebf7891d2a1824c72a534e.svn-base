package com.alnton.myframecore.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * <屏幕密度工具类>
 * @author  王乾州
 * @createon 2014年7月7日
 */
public class DensityUtil
{
    private static DensityUtil densityUtil;
    
    public static DensityUtil getInstance()
    {
        if (null == densityUtil)
        {
            densityUtil = new DensityUtil();
        }
        return densityUtil;
    }
    
    /**
     * <获取屏幕的密度>
     *  @param context
     */
    public float getDisplayDensity(Context context)
    {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        return dm.density;
    }
    
    /**
     * <获取屏幕的高>
     *  @param context
     */
    public int getDisplayHeight(Context context)
    {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
    
    /**
     * <获取屏幕的宽>
     *  @param context
     */
    public int getDisplayWidth(Context context)
    {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
    
    /**
     * <dip转化为像素>
     * @param context
     * @param dipValue
     * @return
     */
    public int dip2px(Context context, float dipValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }
    
    /**
     * <像素转化为dip>
     * @param context
     * @param pxValue
     * @return
     */
    public int px2dip(Context context, float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}