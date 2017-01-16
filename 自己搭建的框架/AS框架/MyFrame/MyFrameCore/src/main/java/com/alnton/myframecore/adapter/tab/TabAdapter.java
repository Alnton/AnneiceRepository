package com.alnton.myframecore.adapter.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.alnton.myframecore.R;
import com.alnton.myframecore.entity.TabInfo;

import java.util.ArrayList;


/**
 * <标签适配器>
 * @author  王乾州
 */
public class TabAdapter extends BaseAdapter
{
    /**
     * 应用程序上下文
     */
    private Context mContext;
    
    /**
     * 标签集合
     */
    private ArrayList<TabInfo> tabInfoList;
    
    /**
     * 文本标签控件数组
     */
    public TextView[] mTextView;
    
    /**
     * 选择之前，之后颜色值
     */
    private int selectBeforeColor, selectAfterColor;
    
    /**
     * 布局反射器
     */
    public LayoutInflater inflater;
    
    public TabAdapter(Context context, ArrayList<TabInfo> tabInfoList, int selectBeforeColor, int selectAfterColor)
    {
        this.mContext = context;
        this.tabInfoList = tabInfoList;
        this.selectAfterColor = selectAfterColor;
        this.selectBeforeColor = selectBeforeColor;
        mTextView = new TextView[tabInfoList.size()];
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    public final class ViewHolder
    {
        /**
         * 标签文本控件
         */
        public TextView mHomePageBottomTV;
        
        /**
         * 标签文本
         */
        public String tabStr;
    }
    
    @Override
    public int getCount()
    {
        return tabInfoList.size();
    }
    
    @Override
    public Object getItem(int position)
    {
        return tabInfoList.get(position);
    }
    
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder viewHolder;
        if (null == convertView)
        {
            viewHolder = new ViewHolder();
            
            convertView = inflater.inflate(R.layout.tab_item, null);
            viewHolder.mHomePageBottomTV = (TextView)convertView.findViewById(R.id.tabTextView);
            
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        
        if (null == mTextView[position])
        {
            mTextView[position] = viewHolder.mHomePageBottomTV;
        }
        
        if (parent.getChildCount() == position)
        {
            //里面就是正常的position
            if (0 == position)
            {
                mTextView[0].setTextColor(mContext.getResources().getColor(selectAfterColor));
            }
            else
            {
                mTextView[position].setTextColor(mContext.getResources().getColor(selectBeforeColor));
            }
        }
        
        /**
         * 赋值
         */
        TabInfo tabInfo = tabInfoList.get(position);
        if (null != tabInfo)
        {
            viewHolder.tabStr = tabInfo.getName();
        }
        viewHolder.mHomePageBottomTV.setText(viewHolder.tabStr);
        return convertView;
    }
    
    /**
     * 点击设置
     * @param selectedID
     */
    public void setFocus(int cacheTabIndex, int selectedID)
    {
        if (cacheTabIndex != selectedID)
        {
            mTextView[selectedID].setTextColor(mContext.getResources().getColor(selectAfterColor));
            mTextView[cacheTabIndex].setTextColor(mContext.getResources().getColor(selectBeforeColor));
        }
    }
}