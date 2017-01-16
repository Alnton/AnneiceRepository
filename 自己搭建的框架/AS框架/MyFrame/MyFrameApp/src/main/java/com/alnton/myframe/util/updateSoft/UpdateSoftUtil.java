package com.alnton.myframe.util.updateSoft;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.alnton.myframe.R;
import com.alnton.myframe.application.Session;
import com.alnton.myframe.config.Config;
import com.alnton.myframe.entity.UpdateVersion;
import com.alnton.myframe.ui.main.MainActivity;
import com.alnton.myframe.util.updateSoft.DownloadApkService.DownloadBinder;
import com.alnton.myframecore.okhttp.OKHttpUtil;
import com.alnton.myframecore.okhttp.callback.ResultCallback;
import com.alnton.myframecore.okhttp.request.RequestParams;
import com.alnton.myframecore.util.ApkUtil;

/**
 * 版本更新工具类
 *
 * @author 王乾州
 * @createon 2016-9-22
 */
public enum UpdateSoftUtil {
    instance;

    UpdateSoftUtil() {

    }

    /**
     * 版本更新实体类
     */
    private UpdateVersion updateVersion;

    /**
     * 应用程序上下文
     */
    private Context context;

    /**
     * 是否更新软件
     */
    public void isUpdateSoft(final Context mContext) {
        this.context = mContext;

        RequestParams params = new RequestParams();
        params.put("verType", "0");

        OKHttpUtil.instance.onPostParams(Config.URLConfig.CHECK_SOFT_UPDATE_URL,
                params, new ResultCallback<UpdateVersion>() {
                    @Override
                    public void onResponse(UpdateVersion infoModel) {
                        updateVersion = infoModel;
                        if (null != updateVersion.getVerCode() && updateVersion.getVerCode().length() > 0) {
                            if (!ApkUtil.getInstance(mContext).getVersionName(context).equals(updateVersion.getVerCode())) {
                                alterDiolog();
                            }
                        }
                    }
                });
    }

    /**
     * 弹出
     */
    private void alterDiolog() {
        View dialog_confirm = Session.getInstance().inflater.inflate(R.layout.dialog_softupdate, null);
        final Dialog dialog = new Dialog(context, R.style.customDialogTheme);
        dialog.setContentView(dialog_confirm);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    // finish();
                }
                return true;
            }
        });
        Button btn_ok = (Button) dialog_confirm.findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 退出登录
                Session.getInstance().sharedPreferencesUtil.clear();

                dialog.cancel();
                View dialog_confirm = Session.getInstance().inflater.inflate(R.layout.dialog_softupdate_ing, null);
                Dialog dialog = new Dialog(context, R.style.customDialogTheme);
                dialog.setContentView(dialog_confirm);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                Intent intentDownload = new Intent(context, DownloadApkService.class);
                context.bindService(intentDownload, conn, Context.BIND_AUTO_CREATE);
            }
        });
        TextView tv_text = (TextView) dialog_confirm.findViewById(R.id.tv_text);
        tv_text.setText(updateVersion.getVerDesc());
        Button btn_no = (Button) dialog_confirm.findViewById(R.id.btn_no);
        btn_no.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        if (updateVersion.getDownType().equals("0")) {
            btn_no.setVisibility(View.GONE);
        } else {
            btn_no.setVisibility(View.VISIBLE);
        }
        dialog.show();
    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DownloadBinder binder = (DownloadBinder) service;
            // 开始下载
            binder.addCallback(callback);
            String apkName = updateVersion.getDownUrl();
            if (!TextUtils.isEmpty(apkName) && apkName.contains("/")) {
                apkName = apkName.substring(apkName.lastIndexOf("/") + 1);
            } else {
                apkName = "MyFrame.apk";
            }
            binder.start(apkName, updateVersion.getDownUrl());
        }
    };

    private ICallbackResult callback = new ICallbackResult() {
        @Override
        public void OnBackResult(Object result) {
            if ("finish".equals(result)) {
                if ("GoogleRefreshLayoutActivity".equals(context.getClass().getSimpleName())) {
                    MainActivity mainActivity = (MainActivity) context;
                    mainActivity.finish();
                }
                return;
            }
        }
    };
}