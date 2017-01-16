package com.alnton.myFrameResource.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alnton.myFrameResource.R;

/**
 * <用于存放所有公共的方法>
 * 
 * @author 王乾州
 */
public class MyFrameResourceTools
{
    private static MyFrameResourceTools tools;
    
    public static MyFrameResourceTools getInstance()
    {
        if (null == tools)
        {
            tools = new MyFrameResourceTools();
        }
        return tools;
    }
    
    /**
     * 显示对话框
     * 
     * @param context
     *            :应用程序上下文
     * @author 王乾州
     */
    public View showDialog(Context context)
    {
        final Dialog exitDialog = new CustomDialog(context, R.style.FullScreenDialog);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        return view;
    }
    
    /**
     * 显示底部对话框
     * 
     * @param context
     *            :应用程序上下文
     * @author 王乾州
     */
    public View showDialogFromBottom(Context context, int layoutId)
    {
        final Dialog bottomDialog = new CustomBottomDialog(context, R.style.transparentFrameWindowStyle, layoutId);
        bottomDialog.show();
        View view = bottomDialog.getWindow().getDecorView();
        view.setTag(bottomDialog);
        return view;
    }
    
    /**
     * 显示中部对话框
     * 
     * @param context
     *            :应用程序上下文
     * @author 王乾州
     */
    public View showDialogCenter(Context context, int layoutId)
    {
        final Dialog exitDialog = new CustomCenterDialog(context, R.style.transparentFrameWindowStyle, layoutId);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        return view;
        
    }
    
    /**
     * 显示选择年月对话框
     * 
     * @param context
     *            :应用程序上下文
     * @author 王乾州
     */
    public View showYearMonthDialog(Context context)
    {
        final Dialog exitDialog = new YearMonthDialog(context, R.style.FullScreenDialog);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        return view;
    }
    
    /**
     * 没有网络时对话框的显示
     * 
     * @param context
     *            :应用程序上下文
     * @author 王乾州
     */
    public View noNetDialogShow(final Context context)
    {
        View view = MyFrameResourceTools.getInstance().showDialog(context);
        final Dialog settingNetDialog = (CustomDialog)view.getTag();
        
        TextView dialogTitleTextView = (TextView)view.findViewById(R.id.dialogTitleTextView);
        dialogTitleTextView.setText(R.string.setting_network);
        
        TextView dialogContentTextView = (TextView)view.findViewById(R.id.dialogContentTextView);
        dialogContentTextView.setText(R.string.network_wrong);
        
        Button settingNetImageView = (Button)view.findViewById(R.id.confirmBtn);
        settingNetImageView.setText(R.string.setting_network);
        
        settingNetImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /* 当网络不可用时，跳转到网络设置页面 */
                settingNetDialog.dismiss();
                ((Activity)context).startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        view.setTag(settingNetDialog);
        return view;
    }
    
    /**
     * <Activity的跳转及传值>
     */
    public void startActivity(Context fromClass, Class<?> toClass, Bundle bundle)
    {
        Intent intent = new Intent();
        intent.setClass(fromClass, toClass);
        if (null != bundle)
        {
            intent.putExtras(bundle);
        }
        fromClass.startActivity(intent);
        bundle = null;
    }
    
    /**
     * <Activity的跳转及传值>
     */
    public void startActivityForResult(Context fromClass, Class<?> toClass, Bundle bundle, int requestCode)
    {
        Intent intent = new Intent();
        intent.setClass(fromClass, toClass);
        if (null != bundle)
        {
            intent.putExtras(bundle);
        }
        ((Activity)fromClass).startActivityForResult(intent, requestCode);
        bundle = null;
    }
}