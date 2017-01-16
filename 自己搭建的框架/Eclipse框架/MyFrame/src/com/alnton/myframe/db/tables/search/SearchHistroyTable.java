package com.alnton.myframe.db.tables.search;

/**
 * <历史搜索表结构>
 * @author  王乾州
 * @createon Jun 2, 2015
 */
public interface SearchHistroyTable
{
    /**
     * 主键
     */
    final String _ID = "_id";
    
    /**
     * 商品或者商家搜索名称
     */
    final String NAME = "name";
    
    /**
     * 搜索时间
     */
    final String TIME = "time";
    
    /**
     * 标志位
     * 1:商品  2:商家
     */
    final String FLAG = "flag";
}