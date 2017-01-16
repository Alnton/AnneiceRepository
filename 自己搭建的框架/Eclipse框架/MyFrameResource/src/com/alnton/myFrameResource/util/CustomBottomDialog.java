package com.alnton.myFrameResource.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.alnton.myFrameResource.R;

/**
 * <底部弹出框>
 * @author  王乾州
 */
public class CustomBottomDialog extends Dialog
{
    /**
     * 布局id
     */
    private int layoutId;
    
    public CustomBottomDialog(Context context, int theme, int layoutId)
    {
        super(context, theme);
        this.layoutId = layoutId;
    }
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        Window window = getWindow();
        // 设置显示动画
        window.setWindowAnimations(R.style.bottomDialog_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindow().getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        
        // 设置显示位置
        onWindowAttributesChanged(wl);
        // 设置点击外围解散
        setCanceledOnTouchOutside(true);
    }
}