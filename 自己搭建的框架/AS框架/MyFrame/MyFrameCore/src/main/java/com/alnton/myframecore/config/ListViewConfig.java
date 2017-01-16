package com.alnton.myframecore.config;

/**
 * <ListView配置文件>
 *
 * @author 王乾州
 */
public enum ListViewConfig {
    instance;

    ListViewConfig() {
    }

    /**
     * ListView 列表每页加载数量
     */
    public final int PAGESIZE = 20;

    /**
     * ListView列表控件的状态
     */
    public final int LISTVIEW_ACTION_INIT = 0x01;

    public final int LISTVIEW_ACTION_REFRESH = 0x02;

    public final int LISTVIEW_ACTION_MORE = 0x03;

    /**
     * 用户被挤掉返回的code失败码
     */
    public final int RETURN_406_CODE = 406;
}