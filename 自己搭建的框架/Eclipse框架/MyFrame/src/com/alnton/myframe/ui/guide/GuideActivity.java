package com.alnton.myframe.ui.guide;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alnton.myFrameResource.util.MyFrameResourceTools;
import com.alnton.myFrameResource.view.Guide.MyScrollLayout;
import com.alnton.myFrameResource.view.Guide.OnViewChangeListener;
import com.alnton.myframe.R;
import com.alnton.myframe.application.Session;
import com.alnton.myframe.ui.BaseActivity;
import com.alnton.myframe.ui.main.MainActivity;

/**
 * <滑动欢迎指引页>
 * @author  王乾州
 */
public class GuideActivity extends BaseActivity implements OnViewChangeListener, OnClickListener
{
    /**
     * 自定义滑动页的布局
     */
    private MyScrollLayout mScrollLayout;
    
    /**
     * 圆点图片数组
     */
    private ImageView[] imgs;
    
    /**
     * 指引页数量
     */
    private int count;
    
    /**
     * 当前条目
     */
    private int currentItem;
    
    /**
     * 立即体验
     */
    private TextView immediately_begin_TextView;
    
    /**
     * 圆点区域布局
     */
    private LinearLayout pointLLayout;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        
        /**
         * 初始化View
         */
        initView();
        
        /**
         * 初始化事件监听
         */
        setListener();
    }
    
    private void initView()
    {
        mScrollLayout = (MyScrollLayout)findViewById(R.id.ScrollLayout);
        pointLLayout = (LinearLayout)findViewById(R.id.llayout);
        immediately_begin_TextView = (TextView)findViewById(R.id.immediately_begin_TextView);
        count = mScrollLayout.getChildCount();
        imgs = new ImageView[count];
        for (int i = 0; i < count; i++)
        {
            imgs[i] = (ImageView)pointLLayout.getChildAt(i);
            imgs[i].setEnabled(true);
            imgs[i].setTag(i);
        }
        currentItem = 0;
        imgs[currentItem].setEnabled(false);
        mScrollLayout.SetOnViewChangeListener(this);
    }
    
    private void setListener()
    {
        immediately_begin_TextView.setOnClickListener(this);
    }
    
    @Override
    public void OnViewChange(int position)
    {
        setcurrentPoint(position);
    }
    
    private void setcurrentPoint(int position)
    {
        if (position < 0 || position > count - 1 || currentItem == position)
        {
            return;
        }
        imgs[currentItem].setEnabled(true);
        imgs[position].setEnabled(false);
        currentItem = position;
    }
    
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.immediately_begin_TextView:
                /**
                 * 将first_sharedpreferences置为false,标志不是第一次启动了
                 */
                Session.getInstance().sharedPreferencesUtil.put(Session.getInstance().sharedPreferencesUtil.SHAREDPREFERENCES_FIRST, false);
                
                /**
                 * 进入主界面
                 */
                MyFrameResourceTools.getInstance().startActivity(mContext, MainActivity.class, null);
                finish();
                break;
            
            default:
                break;
        }
    }
}