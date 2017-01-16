package com.alnton.myFrameResource.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

/**
 * <中部弹出对话框>
 * @author  王乾州
 */
public class CustomCenterDialog extends Dialog
{
    /**
     * 布局id
     */
    private int layoutId;
    
    public CustomCenterDialog(Context context, int theme, int layoutId)
    {
        super(context, theme);
        this.layoutId = layoutId;
    }
    
    protected void onCreate(Bundle savedInstanceState)
    {
    	 super.onCreate(savedInstanceState);
         setContentView(layoutId);
         WindowManager m = getWindow().getWindowManager();
         Display d = m.getDefaultDisplay();
         LayoutParams p = getWindow().getAttributes();
         p.width = (int) (d.getWidth() * 0.9);
         p.height = (int) (d.getHeight() * 0.5);
         getWindow().setAttributes(p);
    }
}