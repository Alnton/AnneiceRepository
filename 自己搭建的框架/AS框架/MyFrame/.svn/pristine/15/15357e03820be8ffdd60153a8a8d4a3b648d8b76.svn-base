package com.alnton.myframecore.view.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.alnton.myframecore.R;


/**
 * 自定义对话框 只有中间和底部展示
 *
 * @Author 詹海
 */
public class CustomDialog extends Dialog {

    /**
     * dialog监听
     */
    private CustomDialogListener customDialogListener;

    /**
     * 布局id
     */
    private int layoutId;

    /**
     * 是否从底部弹出  true：弹出  false：中间展示
     */
    private boolean isBottom;

    /**
     * Description: 自定义对话框
     *
     * @param context  上下文
     * @param isBottom 是否从底部弹出  true：弹出  false：中间展示
     * @param layoutId 布局id
     */
    public CustomDialog(Context context, boolean isBottom, int layoutId) {
        super(context, R.style.customDialogTheme);
        this.isBottom = isBottom;
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

        // 设置点击外围不解散
        setCanceledOnTouchOutside(false);

        if (isBottom) {
            bottomDialog();
        }
    }

    /**
     * @Description: 是底部对话框
     */
    private void bottomDialog() {
        Window window = getWindow();
        // 设置显示动画
        window.setWindowAnimations(R.style.customDialogAnimstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = window.getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        // 设置显示位置
        onWindowAttributesChanged(wl);
    }

    @Override
    public void dismiss() {
        super.dismiss();

        if (null != customDialogListener) {
            customDialogListener.onDismissed();
        }
    }

    public void show(CustomDialogListener customDialogListener) {
        this.customDialogListener = customDialogListener;

        if (null != customDialogListener) {
            customDialogListener.onBuildView(getWindow().getDecorView(), this);
        }

        super.show();
    }

    /**
     * @Description: 自定义对话框销毁的监听
     * @Author 詹海
     */
    public interface CustomDialogListener {

        /**
         * @param view
         * @param customDialog
         * @Description: 对 view 设置事件
         */
        public void onBuildView(View view, CustomDialog customDialog);

        /**
         * @Description: 自定义对话框已销毁
         */
        public void onDismissed();
    }

    /**
     * @Description: 使用案例
     */
    private void useCase() {
        Context context = null;
        //布局的id
        int layoutId = 0;

        new CustomDialog(context, true, layoutId)
                .show(new CustomDialogListener() {
                    @Override
                    public void onDismissed() {
                        //对话框销毁后调用
                    }

                    @Override
                    public void onBuildView(View view, CustomDialog customDialog) {
                        //设置View中的事件
                    }
                });
    }

}