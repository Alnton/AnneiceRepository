package com.alnton.myframecore.view.ScrollView.PullToRefresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alnton.myframecore.R;

/**
 * <默认下拉控件布局实现>
 *
 * @author 王乾州
 * @createon 2016-8-8
 */
public class PullDownElasticImp implements IPullDownElastic {
    /**
     * 头部刷新View
     */
    private View refreshView;

    /**
     * 上下箭头指示器
     */
    private ImageView head_arrowImageView;

    /**
     * 头部高度
     */
    private int headContentHeight;

    /**
     * 刷新进度条
     */
    private ProgressBar head_progressBar;

    /**
     * 下拉显示的文本，下拉显示的时间
     */
    private TextView head_tipsTextView, head_lastUpdatedTextView;

    /**
     * 上下文
     */
    private Context mContext;

    public PullDownElasticImp(Context context) {
        mContext = context;
        init();
    }

    private void init() {
        // 刷新视图顶端的view
        refreshView = LayoutInflater.from(mContext).inflate(R.layout.pull_to_refresh_head, null);

        // 指示器view
        head_arrowImageView = (ImageView) refreshView.findViewById(R.id.head_arrowImageView);
        // 刷新bar
        head_progressBar = (ProgressBar) refreshView.findViewById(R.id.head_progressBar);
        // 下拉显示text
        head_tipsTextView = (TextView) refreshView.findViewById(R.id.head_tipsTextView);
        // 下来显示时间
        head_lastUpdatedTextView = (TextView) refreshView.findViewById(R.id.head_lastUpdatedTextView);

        headContentHeight = dip2px(mContext, 50);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * @return
     */
    @Override
    public View getElasticLayout() {
        return refreshView;
    }

    /**
     * @return
     */
    @Override
    public int getElasticHeight() {
        return headContentHeight;
    }

    /**
     * 显示上下箭头
     */
    @Override
    public void showArrow(int visibility) {
        head_arrowImageView.setVisibility(visibility);
    }

    /**
     * @param animation 启动动画
     */
    @Override
    public void startAnimation(Animation animation) {
        head_arrowImageView.startAnimation(animation);
    }

    /**
     * 清除动画
     */
    @Override
    public void clearAnimation() {
        head_arrowImageView.clearAnimation();
    }

    /**
     * @param
     */
    @Override
    public void showProgressBar(int visibility) {
        head_progressBar.setVisibility(visibility);
    }

    /**
     * @param tips
     */
    @Override
    public void setTips(int tips) {
        head_tipsTextView.setText(tips);
    }

    /**
     * @param
     */
    @Override
    public void showLastUpdate(int visibility) {
        head_lastUpdatedTextView.setVisibility(visibility);
    }

    /**
     * @param text
     */
    public void setLastUpdateText(String text) {
        head_lastUpdatedTextView.setText(text);
    }

    /**
     * @param state
     * @param isBack
     */
    @Override
    public void changeElasticState(int state, boolean isBack) {
    }
}
