package com.alnton.myFrameCore.config;

/**
 * <ListView配置文件>
 * @author  王乾州
 */
public class ListViewConfig
{
    private static ListViewConfig instance;
    
    public static ListViewConfig getInstance()
    {
        if (null == instance)
        {
            instance = new ListViewConfig();
        }
        return instance;
    }
    
    /**
     * 分页大小
     */
    public final int PAGE_SIZE = 20;
    
    /**
     * ListView列表控件的状态
     */
    public final int LISTVIEW_ACTION_INIT = 0x01;
    
    public final int LISTVIEW_ACTION_REFRESH = 0x02;
    
    public final int LISTVIEW_ACTION_SCROLL = 0x03;
    
    public final int LISTVIEW_DATA_MORE = 0x04;
    
    public final int LISTVIEW_DATA_LOADING = 0x05;
    
    public final int LISTVIEW_DATA_FULL = 0x06;
    
    public final int LISTVIEW_DATA_EMPTY = 0x07;
}