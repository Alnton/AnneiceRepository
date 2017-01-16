package com.alnton.myframe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * <数据库管理类>
 * @author  王乾州
 * @createon Jun 2, 2015
 */
public class DBManager
{
    /**
     * 应用程序上下文
     */
    private Context mContext;
    
    private SQLiteDatabase db;
    
    private DBHelper helper;
    
    public DBManager(Context context)
    {
        mContext = context;
        helper = new DBHelper(mContext);
    }
    
    public void writeDB()
    {
        if (null != helper)
        {
            db = helper.getWritableDatabase();
        }
    }
    
    public void readDB()
    {
        if (null != helper)
        {
            db = helper.getReadableDatabase();
        }
    }
    
    public void closeDB()
    {
        if (null != db)
        {
            db.close();
        }
    }
    
    /********************************历史搜索表start********************************/
    
    
    /********************************历史搜索表end********************************/
    
    /*****************************首页中的缓存机制start*****************************/
    
    
    /*****************************首页中的缓存机制end*****************************/
}