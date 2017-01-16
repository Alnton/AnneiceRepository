package com.alnton.myframecore.view.ListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.alnton.myframecore.R;

/**
 * <自定义的ListView>
 * @author  王乾州
 */
public class WorkCircleListView extends ListView implements OnScrollListener
{
    /**
     * 头部布局
     */
    private View headView;
    
    /**
     * 头部布局的高度
     */
    private int headViewHeight;
    
    /**
     * 当前的滚动状态
     */
    int currentScrollState;
    
    private float lastDownY;
    
    private int deltaCount;
    
    private int currentState;
    
    private final int DECREASE_HEADVIEW_PADDING = 100;
    
    public final int LOAD_DATA = 101;
    
    private final int DISMISS_CIRCLE = 102;
    
    public static final int LOADSTATE_IDLE = 0;
    
    public static final int LOADSTATE_LOADING = 1;
    
    /**
     * 左上角的转动的圆圈
     */
    private ImageView circle;
    
    private int CircleMarginTop;
    
    private int firstVisibleItem;
    
    /**
     * 下拉刷新接口
     */
    public OnRefreshListener refreshListener;
    
    public Handler handler = new Handler()
    {
        @SuppressLint("NewApi")
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case DECREASE_HEADVIEW_PADDING:
                    setHeadViewPaddingTop(deltaCount);
                    setCircleMargin();
                    break;
                case LOAD_DATA:
                    Thread thread = new Thread(new DismissCircleThread());
                    thread.start();
                    currentState = LOADSTATE_IDLE;
                    break;
                case DISMISS_CIRCLE:
                    int margin = msg.arg1;
                    setCircleMargin(margin);
                    
                    if (margin == 0)
                    {
                        CircleAnimation.stopRotateAnmiation(circle);
                    }
                    // 隐藏左上角的圆圈图片
                    circle.clearAnimation();
                    circle.setVisibility(View.GONE);
                    break;
            }
        }
        
    };
    
    protected void setCircleMargin(int margin)
    {
        MarginLayoutParams lp = (MarginLayoutParams)circle.getLayoutParams();
        lp.topMargin = margin;
        //        lp.topMargin = 0;
        circle.setLayoutParams(lp);
    }
    
    protected void setCircleMargin()
    {
        MarginLayoutParams lp = (MarginLayoutParams)circle.getLayoutParams();
        lp.topMargin = CircleMarginTop - headView.getPaddingTop();
        circle.setLayoutParams(lp);
    }
    
    private class DecreaseThread implements Runnable
    {
        private final static int TIME = 25;
        
        private int decrease_length;
        
        public DecreaseThread(int count)
        {
            decrease_length = count / TIME;
        }
        
        @Override
        public void run()
        {
            for (int i = 0; i < TIME; i++)
            {
                if (i == 24)
                {
                    deltaCount = 0;
                }
                else
                {
                    deltaCount = deltaCount - decrease_length;
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                    }
                }
                Message msg = Message.obtain();
                msg.what = DECREASE_HEADVIEW_PADDING;
                handler.sendMessage(msg);
            }
        }
    }
    
    public WorkCircleListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initHeadView(context);
    }
    
    public WorkCircleListView(Context context)
    {
        super(context);
        initHeadView(context);
    }
    
    public WorkCircleListView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        initHeadView(context);
    }
    
    private void initHeadView(Context context)
    {
        headView = LayoutInflater.from(context).inflate(R.layout.workcircle_listview_header, null);
        addHeaderView(headView);
        circle = (ImageView)headView.findViewById(R.id.circleprogress);
        headView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener()
        {
            @Override
            public boolean onPreDraw()
            {
                if (headView.getMeasuredHeight() > 0)
                {
                    headViewHeight = headView.getMeasuredHeight();
                    headView.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                return true;
            }
        });
        setOnScrollListener(this);
        currentScrollState = OnScrollListener.SCROLL_STATE_IDLE;
        currentState = LOADSTATE_IDLE;
        firstVisibleItem = 0;
        CircleMarginTop = 76;
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float downY = event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                lastDownY = downY;
                break;
            case MotionEvent.ACTION_UP:
                if (deltaCount > 0 && currentState != LOADSTATE_LOADING && firstVisibleItem == 0
                    && headView.getBottom() >= headViewHeight)
                {
                    currentState = LOADSTATE_LOADING;
                    decreasePadding(deltaCount);
                    startCircleAnimation();
                    
                    /**
                     * 下拉刷新方法
                     */
                    onRefresh();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int nowDeltaCount = (int)((downY - lastDownY) / 3.0);
                int grepDegree = nowDeltaCount - deltaCount;
                deltaCount = nowDeltaCount;
                if (deltaCount > 0 && currentState != LOADSTATE_LOADING && firstVisibleItem == 0
                    && headView.getBottom() >= headViewHeight)
                {
                    // 显示左上角的圆圈
                    circle.setVisibility(View.VISIBLE);
                    
                    setHeadViewPaddingTop(deltaCount);
                    setCircleViewStay();
                    CircleAnimation.startCWAnimation(circle, 5 * (deltaCount - grepDegree), 5 * deltaCount);
                }
                break;
        }
        
        return super.onTouchEvent(event);
    }
    
    private void startCircleAnimation()
    {
        CircleAnimation.startRotateAnimation(circle);
    }
    
    private class DismissCircleThread implements Runnable
    {
        private final int COUNT = 10;
        
        private final int deltaMargin;
        
        public DismissCircleThread()
        {
            deltaMargin = CircleMarginTop / COUNT;
        }
        
        @Override
        public void run()
        {
            int temp = 0;
            for (int i = 0; i <= COUNT; i++)
            {
                if (i == 10)
                {
                    temp = 0;
                }
                else
                {
                    temp = CircleMarginTop - deltaMargin * i;
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                    }
                }
                Message msg = Message.obtain();
                msg.what = DISMISS_CIRCLE;
                msg.arg1 = temp;
                handler.sendMessage(msg);
            }
        }
    }
    
    private void setCircleViewStay()
    {
        if (headView.getPaddingTop() > (CircleMarginTop))
        {
            MarginLayoutParams lp = (MarginLayoutParams)circle.getLayoutParams();
            lp.topMargin = CircleMarginTop - headView.getPaddingTop();
            circle.setLayoutParams(lp);
        }
    }
    
    public void setOnRefreshListener(OnRefreshListener refreshListener)
    {
        this.refreshListener = refreshListener;
    }
    
    public interface OnRefreshListener
    {
        public void onRefresh();
    }
    
    private void onRefresh()
    {
        if (refreshListener != null)
        {
            refreshListener.onRefresh();
        }
    }
    
    private void setHeadViewPaddingTop(int deltaY)
    {
        headView.setPadding(0, deltaY, 0, 0);
    }
    
    private void decreasePadding(int count)
    {
        Thread thread = new Thread(new DecreaseThread(count));
        thread.start();
    }
    
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
    {
        this.firstVisibleItem = firstVisibleItem;
    }
    
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState)
    {
        currentScrollState = scrollState;
    }
}