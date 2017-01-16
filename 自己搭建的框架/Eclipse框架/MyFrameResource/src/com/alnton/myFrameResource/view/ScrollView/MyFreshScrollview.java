package com.alnton.myFrameResource.view.ScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * <谷歌自带刷新SwipeRefreshLayout嵌套ScrollView时候的下拉加载更多的自定义View>
 * @author  王乾州
 * @createon 2016-12-8
 */
public class MyFreshScrollview extends ScrollView
{
    public ScrollViewListener scrollViewListener = null;
    
    public MyFreshScrollview(Context context)
    {
        super(context);
    }
    
    public MyFreshScrollview(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }
    
    public MyFreshScrollview(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    
    public void setScrollViewListener(ScrollViewListener scrollViewListener)
    {
        this.scrollViewListener = scrollViewListener;
    }
    
    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy)
    {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null)
        {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }
    
    public interface ScrollViewListener
    {
        void onScrollChanged(ScrollView scroll, int x, int y, int oldx, int oldy);
    }
}
