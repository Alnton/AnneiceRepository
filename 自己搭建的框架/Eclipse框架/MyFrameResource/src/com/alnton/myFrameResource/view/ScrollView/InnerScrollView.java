package com.alnton.myFrameResource.view.ScrollView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * <解决ScrollView嵌套ScrollView 子ScrollView不能滑动的问题，这个自定义是子的ScrollView>
 * 调用方法：
 *   innerScrollView.parentScrollView = scrollView1;
 *   scrollView1：    父
 *   innerScrollView：子
 * @author  王乾州
 */
@SuppressLint("NewApi")
public class InnerScrollView extends ScrollView
{
    
    Handler handler;
    
    /**
     * 父的ScrollView
     */
    public ScrollView parentScrollView;
    
    public InnerScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        handler = new Handler();
    }
    
    private int lastScrollDelta = 0;
    
    public void resume()
    {
        overScrollBy(0, -lastScrollDelta, 0, getScrollY(), 0, getScrollRange(), 0, 0, true);
        lastScrollDelta = 0;
    }
    
    int mTop = 10;
    
    /**
     * 将targetView滚到最顶端
     */
    public void scrollTo(final View targetView)
    {
        
        handler.postDelayed(new Runnable()
        {
            
            @Override
            public void run()
            {
                int oldScrollY = getScrollY();
                int top = targetView.getTop() - mTop;
                final int delatY = top - oldScrollY;
                lastScrollDelta = delatY;
                smoothScrollTo(0, top);
            }
        }, 50);
        
    }
    
    private int getScrollRange()
    {
        int scrollRange = 0;
        if (getChildCount() > 0)
        {
            View child = getChildAt(0);
            scrollRange = Math.max(0, child.getHeight() - (getHeight()));
        }
        return scrollRange;
    }
    
    int currentY;
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        if (parentScrollView == null)
        {
            return super.onInterceptTouchEvent(ev);
        }
        else
        {
            if (ev.getAction() == MotionEvent.ACTION_DOWN)
            {
                // 将父scrollview的滚动事件拦截
                currentY = (int)ev.getY();
                setParentScrollAble(false);
                return super.onInterceptTouchEvent(ev);
            }
            else if (ev.getAction() == MotionEvent.ACTION_UP)
            {
                // 把滚动事件恢复给父Scrollview
                setParentScrollAble(true);
            }
            else if (ev.getAction() == MotionEvent.ACTION_MOVE)
            {
            }
        }
        return super.onInterceptTouchEvent(ev);
        
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        View child = getChildAt(0);
        if (parentScrollView != null)
        {
            if (ev.getAction() == MotionEvent.ACTION_MOVE)
            {
                int height = child.getMeasuredHeight();
                height = height - getMeasuredHeight();
                
                int scrollY = getScrollY();
                int y = (int)ev.getY();
                
                // 手指向下滑动
                if (currentY < y)
                {
                    if (scrollY <= 0)
                    {
                        // 如果向下滑动到头，就把滚动交给父Scrollview
                        setParentScrollAble(true);
                        return false;
                    }
                    else
                    {
                        setParentScrollAble(false);
                        
                    }
                }
                else if (currentY > y)
                {
                    if (scrollY >= height)
                    {
                        // 如果向上滑动到头，就把滚动交给父Scrollview
                        setParentScrollAble(true);
                        return false;
                    }
                    else
                    {
                        setParentScrollAble(false);
                        
                    }
                    
                }
                currentY = y;
            }
        }
        
        return super.onTouchEvent(ev);
    }
    
    /**
     * 是否把滚动事件交给父scrollview
     * 
     * @param flag
     */
    private void setParentScrollAble(boolean flag)
    {
        
        parentScrollView.requestDisallowInterceptTouchEvent(!flag);
    }
    
}