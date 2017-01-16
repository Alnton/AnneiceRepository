package com.alnton.myframecore.view.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.alnton.myframecore.R;

import okhttp3.Call;

/**
 * <加载耗时操作时的进度对话框工具类>
 *
 * @author 王乾州
 * @createon 2016-9-21
 */
public enum ProgressDialogUtil {

    /**
     * 单例
     */
    instance;

    /**
     * 自定义dialog
     */
    private Dialog progressDialog;

    /**
     * 自定义布局文件
     */
    private int layoutId;

    /**
     * 加载dialog
     * call: 传这个的目的是为了取消当前的网络请求
     */
    public void showProgressDialog(Context context, final Call call) {
        if (null == progressDialog) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(0 == layoutId ? R.layout.load_dialog : layoutId, null);
            progressDialog = new Dialog(context, R.style.customDialogTheme);
            progressDialog.setContentView(view);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            progressDialog.show();

            progressDialog.setOnKeyListener(new OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP && event.getRepeatCount() == 0) {
                        progressDialog = null;

                        if (null != call) {
                            call.cancel();
                        }
                    }
                    return false;

                }
            });

        }
    }

    /**
     * 隐藏加载的dialog
     */
    public void dismissProgressDialog() {
        if (null != progressDialog) {
            progressDialog.dismiss();
            progressDialog = null;
        }
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