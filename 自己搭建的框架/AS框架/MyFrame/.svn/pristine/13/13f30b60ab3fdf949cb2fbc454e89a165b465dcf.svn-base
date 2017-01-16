package com.alnton.myframecore.view.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alnton.myframecore.R;

/**
 * <Toast工具类>
 *
 * @author 王乾州
 * @createon 2016-9-21
 */
public enum ToastUtil {
    instance;

    /**
     * 自定义Toast
     */
    public Toast toast;

    /**
     * 自定义布局文件
     */
    private int layoutId;

    /**
     * 自定义Toast，展示信息提示
     */
    public void showToast(Context context, String content) {
        if (null == toast) {
            View toastView = LayoutInflater.from(context).inflate(R.layout.toast_xml, null);
            toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(toastView);
            TextView toastContent = (TextView) toastView.findViewById(R.id.toastContentTextView);
            toastContent.setText(content);
        } else {
            TextView toastContent = (TextView) (toast.getView().findViewById(R.id.toastContentTextView));
            toastContent.setText(content);
        }
        toast.show();
    }

    /**
     * 自定义Toast，展示信息提示
     */
    public void showToast(Context context, int content) {
        if (null == toast) {
            View toastView = LayoutInflater.from(context).inflate(0 == layoutId ? R.layout.toast_xml : layoutId, null);
            toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(toastView);
            TextView toastContent = (TextView) toastView.findViewById(R.id.toastContentTextView);
            toastContent.setText(context.getResources().getString(content));
        } else {
            TextView toastContent = (TextView) (toast.getView().findViewById(R.id.toastContentTextView));
            toastContent.setText(context.getResources().getString(content));
        }
        toast.show();
    }

    /**
     * 业务层可以传不同的布局文件
     *
     * @param layoutId
     */
    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }
}