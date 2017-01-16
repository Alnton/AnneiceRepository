package com.alnton.myFrameCore.util;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * <SharedPreferences文件配置工具类>
 * @author  王乾州
 * @createon 2014年6月4日
 */
public class SharedPreferencesUtil
{
    /**
     * 用户SharedPreferences的变量名
     */
    public final String USER_SHAREDPREFERENCES = "userSharedpreferences";
    
    /**
     * 程序第一次启动的标志位存放在SharedPreferences的变量名
     */
    public final String SHAREDPREFERENCES_FIRST = "sharedpreferences_first";
    
    /**
     * 是否上传系统崩溃日志到服务器的标志位存放在SharedPreferences的变量名
     */
    public final String SHAREDPREFERENCES_UPLOAD = "sharedpreferences_upload";
    
    /**
     * SharedPreferences
     */
    private SharedPreferences mShared;
    
    /**
     * 编辑器
     */
    private Editor mEditor;
    
    /**
     * 构造方法。
     * @param context
     *    程序上下文
     * @param mode  
     *    打开的模式。值为Context.MODE_APPEND, Context.MODE_PRIVATE,
     *            Context.WORLD_READABLE, Context.WORLD_WRITEABLE.
     */
    public SharedPreferencesUtil(Context context, int mode)
    {
        mShared = context.getSharedPreferences(USER_SHAREDPREFERENCES, mode);
        mEditor = mShared.edit();
    }
    
    /**
     * 获取保存着的boolean对象。
     *
     * @param key
     *            键名
     * @param defValue
     *            当不存在时返回的默认值。
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public boolean getBoolean(String key, boolean defValue)
    {
        return mShared.getBoolean(key, defValue);
    }
    
    /**
     * 获取保存着的int对象。
     * @param key
     *            键名
     * @param defValue
     *            当不存在时返回的默认值。
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public int getInt(String key, int defValue)
    {
        return mShared.getInt(key, defValue);
    }
    
    /**
     * 获取保存着的long对象。
     * @param key
     *            键名
     * @param defValue
     *            当不存在时返回的默认值。
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public long getLong(String key, long defValue)
    {
        return mShared.getLong(key, defValue);
    }
    
    /**
     * 获取保存着的float对象。
     * @param key
     *            键名
     * @param defValue
     *            当不存在时返回的默认值。
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public float getFloat(String key, float defValue)
    {
        return mShared.getFloat(key, defValue);
    }
    
    /**
     * 获取保存着的String对象。
     * @param key
     *            键名
     * @param defValue
     *            当不存在时返回的默认值。
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public String getString(String key, String defValue)
    {
        return mShared.getString(key, defValue);
    }
    
    /**
     * 获取所有键值对。
     * @return 获取到的所有键值对
     */
    public Map<String, ?> getAll()
    {
        return mShared.getAll();
    }
    
    /**
     * 设置一个键值对，它将在{@linkplain #commit()}被调用时保存
     * 注意：当保存的value不是boolean, byte(会被转换成int保存),int, long, float,
     * String等类型时将调用它的toString()方法进行值的保存。
     * @param key
     *            键名称。
     * @param value
     *            值。
     * @return 引用的KV对象。
     */
    public SharedPreferencesUtil put(String key, Object value)
    {
        if (value instanceof Boolean)
        {
            mEditor.putBoolean(key, (Boolean)value);
        }
        else if (value instanceof Integer || value instanceof Byte)
        {
            mEditor.putInt(key, (Integer)value);
        }
        else if (value instanceof Long)
        {
            mEditor.putLong(key, (Long)value);
        }
        else if (value instanceof Float)
        {
            mEditor.putFloat(key, (Float)value);
        }
        else if (value instanceof String)
        {
            mEditor.putString(key, (String)value);
        }
        else
        {
            if (null == value)
            {
                value = "";
            }
            mEditor.putString(key, value.toString());
        }
        commit();
        return this;
    }
    
    /**
     * 移除键值对。
     * @param key
     *            要移除的键名称。
     * @return 引用的KV对象。
     */
    public SharedPreferencesUtil remove(String key)
    {
        mEditor.remove(key);
        commit();
        return this;
    }
    
    /**
     * 清除所有键值对。
     * @return 引用的KV对象。
     */
    public SharedPreferencesUtil clear()
    {
        mEditor.clear();
        commit();
        return this;
    }
    
    /**
     * 是否包含某个键。
     * @param key
     *            查询的键名称。
     * @return 当且仅当包含该键时返回true, 否则返回false.
     */
    public boolean contains(String key)
    {
        return mShared.contains(key);
    }
    
    /**
     * 返回是否提交成功。
     * @return 当且仅当提交成功时返回true, 否则返回false.
     */
    public boolean commit()
    {
        return mEditor.commit();
    }
}