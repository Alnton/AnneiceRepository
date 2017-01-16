/**
 * created by Alnton
 * Copyright (c) 2016, http://www.alnton.com All Rights Reserved.
 * *                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG             #
 * #                                                   #
 */
package com.alnton.myframecore.view.Swipe.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import com.alnton.myframecore.view.Swipe.adapter.ContactAdapter;

/**
 * Google自带的滑动出现删除按钮等的组件
 * 此自定义目的是：判断当前recyclerview的滑动事件，判断需不需要让划出来的按钮回去
 */
public class SwipeRecyclerView extends RecyclerView {

    private Context mContext;
    int Slop;

    public SwipeRecyclerView(Context context) {
        this(context, null);
    }

    public SwipeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initEvent(context);
    }

    private void initEvent(Context context) {
        mContext = context;
        Slop = ViewConfiguration.get(mContext).getScaledEdgeSlop();
    }


    /**
     * 判断 当前手势触摸的距离是否为拖动的最小距离
     *
     * @param e
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {

        int dx = 0;
        int dy = 0;

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dx = (int) e.getX();
                dy = (int) e.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int tempX = (int) e.getX();
                int tempY = (int) e.getY();
                if (Math.abs(dx - tempX) > Slop && Math.abs(tempY - dy) > Slop) {
                    closeAllOpenedItem();
                }
                break;

        }
        return super.onTouchEvent(e);
    }

    public void closeAllOpenedItem() {
        if (getAdapter() != null)
            ((ContactAdapter) getAdapter()).closeOpenedSwipeItemLayoutWithAnim();
    }
}