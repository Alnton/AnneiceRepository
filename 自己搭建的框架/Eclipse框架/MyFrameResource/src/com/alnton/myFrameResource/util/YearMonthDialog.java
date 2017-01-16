package com.alnton.myFrameResource.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import com.alnton.myFrameResource.R;

/**
 * <选择出生年月的自定义对话框>
 * @author  王乾州
 */
public class YearMonthDialog extends Dialog
{
    public YearMonthDialog(Context context, int theme)
    {
        super(context, theme);
    }
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yearmonthdialog);
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        LayoutParams p = getWindow().getAttributes();
        p.width = (int) (d.getWidth() * 0.9);
        p.height = (int) (d.getHeight() * 0.45);
        getWindow().setAttributes(p);
    }
}