package com.alnton.myframe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.alnton.myframe.db.tables.Tables;
import com.alnton.myframe.db.tables.homepage.ProductTable;
import com.alnton.myframe.db.tables.search.SearchHistroyTable;

/**
 * <数据库工具类>
 * @author  王乾州
 * @createon Jun 2, 2015
 */
public class DBHelper extends SQLiteOpenHelper
{
    /**
     * 数据库版本
     */
    private static final int DATABASE_VERSION = 1;
    
    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME = "MyFrame.db";
    
    /** 
     * <默认构造函数>
     */
    public DBHelper(Context context, String name, CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
    
    /** 
     * <默认构造函数>
     */
    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        /**
         * 历史搜索表
         */
        db.execSQL("CREATE TABLE " + Tables.SEARCHHISTROY + " (" 
            + SearchHistroyTable._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," 
            + SearchHistroyTable.NAME
            + " TEXT," 
            + SearchHistroyTable.TIME
            + " LONG,"
            + SearchHistroyTable.FLAG
            + " INTEGER" + ");");
        
        
        /**
         * 首页中的供货信息表
         */
        db.execSQL("CREATE TABLE " + Tables.PRODUCT + " (" 
            + ProductTable._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," 
            + ProductTable.GOODSSKU
            + " TEXT," 
            + ProductTable.GOODSTITLE
            + " TEXT,"
            + ProductTable.SHOPDETAILEDADDRESS
            + " TEXT,"
            + ProductTable.DIRECTFLAG
            + " TEXT,"
            + ProductTable.SALESNUM
            + " TEXT,"
            + ProductTable.MAXPRICE
            + " TEXT,"
            + ProductTable.MINPRICE
            + " TEXT,"
            + ProductTable.SALEUNIT
            + " TEXT,"
            + ProductTable.LABELLIST
            + " TEXT" + ");");
    }
    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
}