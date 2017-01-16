package com.alnton.myFrameResource.view.Button;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * <点击，背景透明度改变，可以代替 两张效果图片>
 * @author  王乾州
 * @createon 2014年4月21日
 */
public class ClickEffectButton extends Button
{
    
    public ClickEffectButton(Context context)
    {
        super(context);
    }
    
    public ClickEffectButton(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }
    
    public ClickEffectButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    
    @Override
    public void setBackgroundDrawable(Drawable d)
    {
        SAutoBgButtonBackgroundDrawable layer = new SAutoBgButtonBackgroundDrawable(d);
        super.setBackgroundDrawable(layer);
    }
    
    protected class SAutoBgButtonBackgroundDrawable extends LayerDrawable
    {
        
        // The color filter to apply when the button is pressed
        protected ColorFilter _pressedFilter = new LightingColorFilter(Color.LTGRAY, 1);
        
        // Alpha value when the button is disabled
        protected int _disabledAlpha = 100;
        
        public SAutoBgButtonBackgroundDrawable(Drawable d)
        {
            super(new Drawable[] {d});
        }
        
        @Override
        protected boolean onStateChange(int[] states)
        {
            boolean enabled = false;
            boolean pressed = false;
            
            for (int state : states)
            {
                if (state == android.R.attr.state_enabled)
                    enabled = true;
                else if (state == android.R.attr.state_pressed)
                    pressed = true;
            }
            
            mutate();
            if (enabled && pressed)
            {
                setColorFilter(_pressedFilter);
            }
            else if (!enabled)
            {
                setColorFilter(null);
                setAlpha(_disabledAlpha);
            }
            else
            {
                setColorFilter(null);
            }
            
            invalidateSelf();
            
            return super.onStateChange(states);
        }
        
        @Override
        public boolean isStateful()
        {
            return true;
        }
    }
}