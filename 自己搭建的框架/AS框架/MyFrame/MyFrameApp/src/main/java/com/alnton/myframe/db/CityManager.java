package com.alnton.myframe.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alnton.myframe.entity.City;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * <城市数据库管理类>
 * @author  王乾州
 */
public class CityManager
{
    /**
     * 应用程序上下文
     */
    private Context mContext;
    
    /**
     * 数据库辅助类
     */
    private SQLiteDatabase db;
    
    /**
     * 数据库工具类
     */
    private DBHelper helper;
    
    /**
     * 数据库名称
     */
    private final String DB_NAME = "citys.db";
    
    /** 
     * <默认构造函数>
     */
    public CityManager(Context context)
    {
        mContext = context;
        helper = new DBHelper(mContext, DB_NAME, null, 1);
    }
    
    /**
     * <打开数据库>
     */
    public void open()
    {
        if (null != helper)
        {
            db = helper.getReadableDatabase();
        }
    }
    
    /**
     * <关闭数据库>
     */
    public void close()
    {
        if (null != helper)
        {
            helper.close();
        }
    }
    
    /**
     * <初始化城市数据库>
     */
    public void insertDb()
    {
        String DB_PATH = "data/data/" + mContext.getPackageName() + "/databases/";
        
        File f = new File(DB_PATH);
        File file = new File(DB_PATH + DB_NAME);
        if (!f.exists())
        {
            f.mkdir();
        }
        
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
        try
        {
            InputStream is = mContext.getClassLoader().getResourceAsStream("assets/"+DB_NAME);
            OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0)
            {
                os.write(buffer, 0, length);
            }
            // 关闭文件流 
            os.flush();
            os.close();
            is.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取省份集合
     */
    public ArrayList<City> queryProvinces()
    {
        ArrayList<City> list = new ArrayList<City>();
        
        try
        {
            open();
            
            Cursor cursor = db.query("t", null, "sub_city_code = -1", null, null, null, null);
            while (cursor.moveToNext())
            {
                City city = new City();
                city.setArea_code(cursor.getString(cursor.getColumnIndex("area_code")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setCityId(cursor.getString(cursor.getColumnIndex("city_id")));
                city.setCityKey(cursor.getString(cursor.getColumnIndex("city_key")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setEnd_flag(cursor.getInt(cursor.getColumnIndex("end_flag")));
                city.setPostalcode(cursor.getString(cursor.getColumnIndex("postalcode")));
                city.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                city.setSub_city_code(cursor.getString(cursor.getColumnIndex("sub_city_code")));
                list.add(city);
            }
        }
        finally
        {
            close();
        }
        return list;
    }
    
    /**
     * <根据省份/城市的id 获取 城市/区县>
     * @param code 为 省份/城市的code
     * @return
     */
    public ArrayList<City> queryCitysTowns(String code)
    {
        ArrayList<City> list = new ArrayList<City>();
        
        try
        {
            open();
            
            Cursor cursor = db.query("t", null, "sub_city_code = ?", new String[] {code}, null, null, null);
            
            while (cursor.moveToNext())
            {
                City city = new City();
                city.setArea_code(cursor.getString(cursor.getColumnIndex("area_code")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setCityId(cursor.getString(cursor.getColumnIndex("city_id")));
                city.setCityKey(cursor.getString(cursor.getColumnIndex("city_key")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setEnd_flag(cursor.getInt(cursor.getColumnIndex("end_flag")));
                city.setPostalcode(cursor.getString(cursor.getColumnIndex("postalcode")));
                city.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                city.setSub_city_code(cursor.getString(cursor.getColumnIndex("sub_city_code")));
                list.add(city);
            }
        }
        finally
        {
            close();
        }
        return list;
    }
}