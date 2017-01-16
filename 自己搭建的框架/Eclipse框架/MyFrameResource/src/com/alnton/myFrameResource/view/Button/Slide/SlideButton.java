package com.alnton.myFrameResource.view.Button.Slide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alnton.myFrameResource.R;

/**
 * <自定义开关按钮的View>
 * @author  王乾州
 */
public class SlideButton extends RelativeLayout implements OnClickListener, AnimationListener
{
    /**
     * 开关上面的白色图片
     */
    private ImageView indicate;
    
    /**
     * 开关文字
     */
    private TextView left, right;
    
    private boolean isChgLsnOn = false;
    
    private volatile boolean b_chgIng = false;
    
    private OnChangedListener ChgLsn;
    
    private volatile boolean enableChgListener = false;
    
    public boolean isEnableChgListener()
    {
        return enableChgListener;
    }
    
    public void setEnableChgListener(boolean enableChgListener)
    {
        this.enableChgListener = enableChgListener;
    }
    
    public SlideButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.setOnClickListener(this);
    }
    
    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        indicate = (ImageView)this.findViewById(R.id.indicate);
        left = (TextView)this.findViewById(R.id.textView1);
        right = (TextView)this.findViewById(R.id.textView2);
        
    }
    
    public void SetOnChangedListener(OnChangedListener l)
    {
        //设置监听器,当状态修改的时候   
        ChgLsn = l;
        
    }
    
    public void setState(boolean state)
    {
        if (isChgLsnOn != state)
        {
            
            if (state)
            {
                indicate.setAnimation(getGoRightAnimation());
                isChgLsnOn = true;
            }
            else
            {
                indicate.setAnimation(getGoLeftAnimation());
                isChgLsnOn = false;
            }
            
        }
        
    }
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        super.onLayout(changed, l, t, r, b);
        ViewGroup.LayoutParams lp = indicate.getLayoutParams();
        lp.width = left.getWidth();
        lp.height = left.getHeight();
        indicate.setLayoutParams(lp);
    }
    
    @Override
    public void onClick(View v)
    {
        enableChgListener = true;
        if (!b_chgIng)
        {
            if (isChgLsnOn)
            {
                indicate.setAnimation(getGoLeftAnimation());
                isChgLsnOn = false;
            }
            else
            {
                indicate.setAnimation(getGoRightAnimation());
                isChgLsnOn = true;
            }
            (indicate.getAnimation()).setAnimationListener(this);
            (indicate.getAnimation()).startNow();
        }
        
    }
    
    private AnimationSet getGoRightAnimation()
    {
        
        AnimationSet animationSet_bottom_out = new AnimationSet(true);
        // 第一个参数fromAlpha为 动画开始时候透明度
        // 第二个参数toAlpha为 动画结束时候透明度
        
        AlphaAnimation myAnimation_Alpha_bottom_out = new AlphaAnimation(0.0f, 1.0f);
        // 说明:
        // 0.0表示完全透明
        // 1.0表示完全不透明
        
        // 设置时间持续时间为 5000毫秒
        TranslateAnimation myTranslateAnimation_bottom_out =
            new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        
        // 第一个参数fromXDelta为动画起始时 X坐标上的移动位置
        // 第二个参数toXDelta为动画结束时 X坐标上的移动位置
        // 第三个参数fromYDelta为动画起始时Y坐标上的移动位置
        // 第四个参数toYDelta为动画结束时Y坐标上的移动位置
        
        // animationSet_bottom_out.addAnimation(myAnimation_Alpha_bottom_out);
        animationSet_bottom_out.addAnimation(myTranslateAnimation_bottom_out);
        animationSet_bottom_out.setFillAfter(true);
        animationSet_bottom_out.setDuration(150);
        return animationSet_bottom_out;
    }
    
    private AnimationSet getGoLeftAnimation()
    {
        
        AnimationSet animationSet_bottom_in = new AnimationSet(true);
        // 第一个参数fromAlpha为 动画开始时候透明度
        // 第二个参数toAlpha为 动画结束时候透明度
        AlphaAnimation myAnimation_Alpha_bottom_in = new AlphaAnimation(0.0f, 1.0f);
        // 说明:
        // 0.0表示完全透明
        // 1.0表示完全不透明
        
        // 设置时间持续时间为 5000毫秒
        TranslateAnimation myTranslateAnimation_bottom_in =
            new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        
        // 第一个参数fromXDelta为动画起始时 X坐标上的移动位置
        // 第二个参数toXDelta为动画结束时 X坐标上的移动位置
        // 第三个参数fromYDelta为动画起始时Y坐标上的移动位置
        // 第四个参数toYDelta为动画结束时Y坐标上的移动位置
        
        // animationSet_bottom_in.addAnimation(myAnimation_Alpha_bottom_in);
        animationSet_bottom_in.addAnimation(myTranslateAnimation_bottom_in);
        animationSet_bottom_in.setFillAfter(true);
        animationSet_bottom_in.setDuration(150);
        return animationSet_bottom_in;
    }
    
    @Override
    public void onAnimationEnd(Animation animation)
    {
        
        b_chgIng = false;
        
        if (null != ChgLsn && enableChgListener)
        {
            ChgLsn.OnChanged(isChgLsnOn);
        }
    }
    
    @Override
    public void onAnimationRepeat(Animation animation)
    {
    }
    
    @Override
    public void onAnimationStart(Animation animation)
    {
        b_chgIng = true;
    }
}