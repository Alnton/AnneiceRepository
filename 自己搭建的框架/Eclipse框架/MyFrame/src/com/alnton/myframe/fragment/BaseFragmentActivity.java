package com.alnton.myframe.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

import com.alnton.myFrameCore.util.TelephoneUtil;
import com.alnton.myframe.application.Session;
import com.alnton.myframe.util.ProgressDialogUtil;
import com.alnton.myframe.util.ToastUtil;

/**
 * 程序界面FragmentActivity基类
 * 备注:android 6.0.1 之后不可以在onStop()里面对软键盘做任何操作  Activity可以 FragmentActivity不可以
 * @author 王乾州
 */
public class BaseFragmentActivity extends FragmentActivity
{
    /**
     * 应用程序上下文
     */
    public Context mContext;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        mContext = this;
        
        /**
         * 将每个界面都加入集合中，目的完全退出
         */
        Session.getInstance().addActivity(this);
        
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected void onPause()
    {
        /**
         * 关闭展示的进度对话框
         */
        ProgressDialogUtil.instance.dismissProgressDialog();
        
        super.onPause();
    }
    
    @Override
    protected void onDestroy()
    {
        /**
         * 关闭展示的Toast
         */
        if (null != ToastUtil.instance.toast)
        {
            ToastUtil.instance.toast.cancel();
        }
        
        super.onDestroy();
    }
    
    /**
     * 点击空白处隐藏输入法
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
        {
            /**
             * 统一检测输入框是否弹出，弹出则关闭
             */
            TelephoneUtil.getInstance().closeKeyboard(BaseFragmentActivity.this);
        }
        return super.dispatchTouchEvent(ev);
    }
    
    /**
     * Android设定字体大小，不随系统变化
     */
    @Override
    public Resources getResources()
    {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}