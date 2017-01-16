package com.alnton.myframecore.adapter.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.alnton.myframecore.entity.TabInfo;

import java.util.ArrayList;


/**
 * <Fragment左右滑动适配器>
 * @author  王乾州
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter
{
    /**
     * Fragment管理类
     */
    private FragmentManager fm;
    
    /**
     * Fragment集合
     */
    private ArrayList<TabInfo> tabInfoList;
    
    public MyFragmentPagerAdapter(Context context, FragmentManager fm, ArrayList<TabInfo> tabInfoList)
    {
        super(fm);
        this.fm = fm;
        this.tabInfoList = tabInfoList;
    }
    
    /**
     * 获取position处的item(Fragment)
     */
    @Override
    public Fragment getItem(int position)
    {
        return tabInfoList.get(position % tabInfoList.size()).getFragment();
    }
    
    @Override
    public int getItemPosition(Object object)
    {
        return POSITION_NONE;
    }
    
    @Override
    public int getCount()
    {
        return tabInfoList.size();
    }
    
    /**
     * 初始化position处的item 加载所有子的Fragment
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        //得到缓存的fragment
        Fragment fragment = (Fragment)super.instantiateItem(container, position);
        
        //得到tag
        String fragmentTag = fragment.getTag();
        
        if (tabInfoList.get(position % tabInfoList.size()).isUpdateFragment())
        {
            //如果这个fragment需要更新
            FragmentTransaction ft = fm.beginTransaction();
            //移除旧的fragment
            ft.remove(fragment);
            //换成新的fragment
            fragment = tabInfoList.get(position % tabInfoList.size()).getFragment();
            //添加新fragment时必须用前面获得的tag，这点很重要
            ft.add(container.getId(), fragment, fragmentTag);
            ft.attach(fragment);
            ft.commit();
            
            //复位更新标志
            tabInfoList.get(position % tabInfoList.size()).setUpdateFragment(false);
        }
        
        return fragment;
    }
    
    public ArrayList<TabInfo> getTabInfoList()
    {
        return tabInfoList;
    }
    
    public void setTabInfoList(ArrayList<TabInfo> tabInfoList)
    {
        this.tabInfoList = tabInfoList;
    }
}