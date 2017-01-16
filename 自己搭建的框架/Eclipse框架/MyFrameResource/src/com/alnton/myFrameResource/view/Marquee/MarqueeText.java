package com.alnton.myFrameResource.view.Marquee;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <失去焦点仍然保留跑马灯的Textview>
 * @author  王乾州
 */
public class MarqueeText extends TextView
{
    public MarqueeText(Context con)
    {
        super(con);
    }
    
    public MarqueeText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    
    public MarqueeText(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }
    
    @Override
    public boolean isFocused()
    {
        return true;
    }
    
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect)
    {
    }
}