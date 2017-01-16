package com.alnton.myFrameResource.entity;

import java.io.Serializable;
import java.util.ArrayList;

import android.support.v4.app.Fragment;

/**
 * <FragmentPagerAdapter中的每个Fragment实体类>
 * @author  王乾州
 */
public class TabInfo implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -2654487299234585308L;
    
    /**
     * 标签名称
     */
    private String name;
    
    /**
     * 标签图标id
     */
    private int icon;
    
    /**
     * 标签索引
     */
    private int index;
    
    /**
     * Fragment 对象
     */
    public Fragment fragment;
    
    /**
     * 数据集合
     */
    private ArrayList<Object> dataList;
    
    /**
     * 是否更新Fragment
     * true:  是
     * false: 否
     */
    private boolean isUpdateFragment = false;
    
    /* 首页动态标签实体类 */
    /**
     * 图片地址
     */
    private String picUrl;
    
    /**
     * 一级分类
     */
    private String typeKey;
    
    /**
     * 连接
     */
    private String classifyLink;
    
    /**
     * 0：无链接，1：商品，2：商家，3：活动页
     */
    private String classifyLinkType;
    
    /* 首页动态标签实体类 */
    
    private String flag;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getIcon()
    {
        return icon;
    }

    public void setIcon(int icon)
    {
        this.icon = icon;
    }
    
    public ArrayList<Object> getDataList()
    {
        return dataList;
    }
    
    public void setDataList(ArrayList<Object> dataList)
    {
        this.dataList = dataList;
    }
    
    public boolean isUpdateFragment()
    {
        return isUpdateFragment;
    }
    
    public void setUpdateFragment(boolean isUpdateFragment)
    {
        this.isUpdateFragment = isUpdateFragment;
    }
    
    public Fragment getFragment()
    {
        return fragment;
    }
    
    public void setFragment(Fragment fragment)
    {
        this.fragment = fragment;
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public void setIndex(int index)
    {
        this.index = index;
    }
    
    public String getPicUrl()
    {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }
    
    public String getTypeKey()
    {
        return typeKey;
    }
    
    
    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setTypeKey(String typeKey)
    {
        this.typeKey = typeKey;
    }

    public String getClassifyLink()
    {
        return classifyLink;
    }

    public void setClassifyLink(String classifyLink)
    {
        this.classifyLink = classifyLink;
    }

    public String getClassifyLinkType()
    {
        return classifyLinkType;
    }

    public void setClassifyLinkType(String classifyLinkType)
    {
        this.classifyLinkType = classifyLinkType;
    }
}