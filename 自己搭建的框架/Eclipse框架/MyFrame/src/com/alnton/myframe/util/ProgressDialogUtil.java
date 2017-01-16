package com.alnton.myframe.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.alnton.myframe.R;
import com.alnton.myframe.application.Session;
import com.alnton.myframe.util.http.HttpInterface;

/**
 * <加载耗时操作时的进度对话框工具类>
 * @author  王乾州
 * @createon 2016-9-21
 */
public enum ProgressDialogUtil
{
    instance;
    
    ProgressDialogUtil()
    {
        
    }
    
    /**
     * 自定义dialog
     */
    private Dialog progressDialog;
    
    /**
     * 加载dialog
     * mContext: 传这个的目的是为了取消当前上下文下所有的网络请求
     */
    public void showProgressDialog(final Context mContext)
    {
        if (null == progressDialog)
        {
            View view = Session.getInstance().inflater.inflate(R.layout.load_dialog, null);
            progressDialog = new Dialog(Session.getInstance().getApplicationContext(), R.style.FullScreenDialog);
            progressDialog.setContentView(view);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            progressDialog.show();

            progressDialog.setOnKeyListener(new OnKeyListener()
            {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)
                {
                    if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP && event.getRepeatCount() == 0)
                    {
                        progressDialog = null;
                        
                        if (null != mContext)
                        {
                            HttpInterface.instance.cancelRequests(mContext, true);
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
    public void dismissProgressDialog()
    {
        if (null != progressDialog)
        {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}