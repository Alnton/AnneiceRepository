package com.alnton.myFrameResource.view.GoogleRefreshLayout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.alnton.myFrameResource.R;
import com.alnton.myFrameResource.view.ScrollView.MyFreshScrollview;

/**
 * 继承自谷歌自带刷新SwipeRefreshLayout,从而实现滑动到底部时上拉加载更多的功能.
 * 当嵌套了ScrollView而非ListView，则布局文件必须这样写：
 * <com.alnton.myFrameResource.view.GoogleRefreshLayout.RefreshLayout
 *       android:id="@+id/swipe_container"
 *       android:layout_width="match_parent"
 *       android:layout_height="match_parent" >
 *
 *       <com.alnton.myFrameResource.view.ScrollView.MyFreshScrollview
 *           android:layout_width="match_parent"
 *           android:layout_height="match_parent" >
 *
 *           <LinearLayout
 *               android:id="@+id/listLayout"
 *               android:layout_width="match_parent"
 *               android:layout_height="match_parent"
 *               android:orientation="vertical" >
 *                 <!-- 里面写业务需求的布局 -->
 *           </LinearLayout>
 *       </com.alnton.myFrameResource.view.ScrollView.MyFreshScrollview>
 *   </com.alnton.myFrameResource.view.GoogleRefreshLayout.RefreshLayout>
 *   外围Activity必须初始化RefreshLayout时候添加一句：myRefreshLayout.setLoadingLayout((LinearLayout)findViewById(R.id.listLayout));
 * @author 王乾州
 */
public class RefreshLayout extends SwipeRefreshLayout implements OnScrollListener
{
    /**
     * 滑动到最下面时的上拉操作
     */
    private int mTouchSlop;
    
    /**
     * listview实例
     */
    private ListView mListView;
    
    /**
     * ScrollView实例
     */
    private MyFreshScrollview myFreshScrollview;
    
    /**
     * 上拉监听器, 到了最底部的上拉加载操作
     */
    private OnLoadListener mOnLoadListener;
    
    /**
     * ListView的加载中footer
     */
    private View mListViewFooter;
    
    /**
     * 按下时的y坐标
     */
    private int mYDown;
    
    /**
     * 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
     */
    private int mLastY;
    
    /**
     * 是否在加载中 ( 上拉加载更多 )
     */
    private boolean isLoading = false;
    
    /**
     * @param context
     */
    private LinearLayout loadingLayout;
    
    /**
     * @param context
     */
    public RefreshLayout(Context context)
    {
        this(context, null);
    }
    
    @SuppressLint("InflateParams")
    public RefreshLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        
        mListViewFooter = LayoutInflater.from(context).inflate(R.layout.listview_footer, null, false);
    }
    
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);
        // 初始化ListView或者ScrollView对象
        if (null == mListView || null == myFreshScrollview)
        {
            getView();
        }
    }
    
    /**
     * 获取ListView或者ScrollView对象
     */
    private void getView()
    {
        int childs = getChildCount();
        if (childs > 0)
        {
            View childView = getChildAt(0);
            if (childView instanceof ListView)
            {
                mListView = (ListView)childView;
                // 设置滚动监听器给ListView, 使得滚动的情况下也可以自动加载
                mListView.setOnScrollListener(this);
            }
            else if (childView instanceof ScrollView)
            {
                myFreshScrollview = (MyFreshScrollview)childView;
                // 设置滚动监听器给MyFreshScrollview, 使得滚动的情况下也可以自动加载
                myFreshScrollview.setScrollViewListener(new MyFreshScrollview.ScrollViewListener()
                {
                    @Override
                    public void onScrollChanged(ScrollView scroll, int x, int y, int oldx, int oldy)
                    {
                        if (canLoad())
                        {
                            loadData();
                        }
                    }
                });
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see android.view.ViewGroup#dispatchTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        final int action = event.getAction();
        
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                // 按下
                mYDown = (int)event.getRawY();
                break;
            
            case MotionEvent.ACTION_MOVE:
                // 移动
                mLastY = (int)event.getRawY();
                break;
            
            case MotionEvent.ACTION_UP:
                // 抬起
                if (canLoad())
                {
                    loadData();
                }
                break;
            default:
                break;
        }
        
        return super.dispatchTouchEvent(event);
    }
    
    /**
     * 是否可以加载更多, 条件是到了最底部, listview不在加载中, 且为上拉操作.
     * @return
     */
    private boolean canLoad()
    {
        return isBottom() && !isLoading && isPullUp();
    }
    
    /**
     * <给调用者设置是否可以显示加载更多的操作>
     * @param isCan:true代表可以   false代表不可以
     */
    public void setCanLoadMore(boolean isCan)
    {
        isLoading = !isCan;
    }
    
    /**
     * <获取是否可以显示加载更多的操作>
     * @return false代表加载完毕可以结束掉了   true代表不可以
     */
    public boolean getCanLoadMore()
    {
        return isLoading;
    }
    
    /**
     * 判断是否到了最底部
     */
    private boolean isBottom()
    {
        if (mListView != null && mListView.getAdapter() != null)
        {
            return mListView.getLastVisiblePosition() == (mListView.getAdapter().getCount() - 1);
        }
        else if (myFreshScrollview != null)
        {
            // 子scroll view滑动到最顶端
            View child = myFreshScrollview.getChildAt(0);
            if (child.getMeasuredHeight() <= getHeight() + myFreshScrollview.getScrollY())
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 是否是上拉操作
     * @return
     */
    private boolean isPullUp()
    {
        return (mYDown - mLastY) >= mTouchSlop;
    }
    
    /**
     * 如果到了最底部,而且是上拉操作.那么执行onLoad方法
     */
    private void loadData()
    {
        if (mOnLoadListener != null)
        {
            // 设置状态
            setLoading(true);
            mOnLoadListener.onLoad();
        }
    }
    
    /**
     * @param loading
     */
    public void setLoading(boolean loading)
    {
        isLoading = loading;
        if (isLoading)
        {
            if (null != mListView)
            {
                if (0 != mListView.getFooterViewsCount())
                {
                    mListView.removeFooterView(mListViewFooter);
                }
                mListView.addFooterView(mListViewFooter);
            }
            else if (null != myFreshScrollview && null != loadingLayout)
            {
                loadingLayout.removeView(mListViewFooter);
                loadingLayout.addView(mListViewFooter);
                myFreshScrollview.scrollTo(0,
                    myFreshScrollview.getChildAt(0).getMeasuredHeight() + mListViewFooter.getMeasuredHeight());
            }
        }
        else
        {
            if (null != mListView)
            {
                mListView.removeFooterView(mListViewFooter);
            }
            else if (null != loadingLayout)
            {
                loadingLayout.removeView(mListViewFooter);
            }
            
            mYDown = 0;
            mLastY = 0;
        }
    }
    
    /**
     * @param loadListener
     */
    public void setOnLoadListener(OnLoadListener loadListener)
    {
        mOnLoadListener = loadListener;
    }
    
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState)
    {
        
    }
    
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
    {
        // 滚动时到了最底部也可以加载更多
        if (canLoad())
        {
            loadData();
        }
    }
    
    /**
     * 设置刷新
     */
    public static void setRefreshing(SwipeRefreshLayout refreshLayout, boolean refreshing, boolean notify)
    {
        Class<? extends SwipeRefreshLayout> refreshLayoutClass = refreshLayout.getClass();
        if (refreshLayoutClass != null)
        {
            try
            {
                Method setRefreshing =
                    refreshLayoutClass.getDeclaredMethod("setRefreshing", boolean.class, boolean.class);
                setRefreshing.setAccessible(true);
                setRefreshing.invoke(refreshLayout, refreshing, notify);
            }
            catch (NoSuchMethodException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 加载更多的监听器
     */
    public static interface OnLoadListener
    {
        public void onLoad();
    }
    
    public void setLoadingLayout(LinearLayout loadingLayout)
    {
        this.loadingLayout = loadingLayout;
    }
}