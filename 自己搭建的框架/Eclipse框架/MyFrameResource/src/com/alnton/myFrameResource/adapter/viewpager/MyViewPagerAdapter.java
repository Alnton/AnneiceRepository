package com.alnton.myFrameResource.adapter.viewpager;

import java.util.ArrayList;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * <左右滑动界面适配器>
 * @author  王乾州
 */
public class MyViewPagerAdapter extends PagerAdapter
{
    private ArrayList<View> myListViews;
    
    public MyViewPagerAdapter(ArrayList<View> myListViews)
    {
        this.myListViews = myListViews;
    }
    
    @Override
    public void destroyItem(View container, int arg1, Object object)
    {
        ((ViewPager)container).removeView((View)object);
    }
    
    @Override
    public void finishUpdate(View arg0)
    {
    }
    
    @Override
    public int getCount()
    {
        return myListViews.size();
    }
    
    @Override
    public Object instantiateItem(View container, int arg1)
    {
        ((ViewPager)container).addView(myListViews.get(arg1));
        return myListViews.get(arg1);
    }
    
    @Override
    public boolean isViewFromObject(View arg0, Object arg1)
    {
        return arg0 == ((View)arg1);
    }
    
    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1)
    {
    }
    
    @Override
    public Parcelable saveState()
    {
        return null;
    }
    
    @Override
    public void startUpdate(View arg0)
    {
    }
}