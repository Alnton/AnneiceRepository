package com.alnton.myFrameResource.view.Tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alnton.myFrameResource.R;
import com.alnton.myFrameResource.adapter.tab.TabAdapter;
import com.alnton.myFrameResource.entity.TabInfo;

/**
 * <标签布局>
 * @author  王乾州
 */
public class TabLayout extends LinearLayout
{
    /**
     * 程序上下文
     */
    private Context context;
    
    public TabLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    
    public void setAdapter(final Context context, TabAdapter adapter, int width, final int flag)
    {
        int count = adapter.getCount();
        for (int i = 0; i < count; i++)
        {
            final TabInfo contacts = (TabInfo)adapter.getItem(i);
            View view = adapter.getView(i, null, null);
            TextView nameTextView = (TextView)view.findViewById(R.id.tabTextView);
            
            nameTextView.setOnClickListener(new OnClickListener()
            {
                
                @Override
                public void onClick(View v)
                {
                    if (null != contacts)
                    {
                        if (0 == flag)
                        {
//                            GridActivity gridActivity = (GridActivity)context;
//                            gridActivity.tabOnClick(contacts.getIndex());
                        }
                    }
                }
            });
            this.setOrientation(HORIZONTAL);
            this.addView(view, new LinearLayout.LayoutParams(width, LayoutParams.WRAP_CONTENT));
        }
    }
}