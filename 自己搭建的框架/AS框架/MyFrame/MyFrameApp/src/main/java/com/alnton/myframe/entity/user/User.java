package com.alnton.myframe.entity.user;

import android.content.Context;
import android.text.TextUtils;

import com.alnton.myframe.application.Session;
import com.alnton.myframe.config.Config.SharedPreferencesConfig;
import com.alnton.myframe.config.Config.SystemParamCfg;
import com.alnton.myframe.ui.login.LoginActivity;
import com.alnton.myframecore.util.MyFrameCoreTools;

/**
 * 所有用户相关信息实体类
 * @Author 詹海
 * @Date 2016-8-5 下午4:55:43
 */
public enum User
{
    /**
     * 单例模式
     */
    instance;
    
    User()
    {
    }
    
    /**
     * 得到登录的key   
     */
    public String getLoginKey()
    {
        return MyFrameCoreTools.getInstance()
            .formatString(Session.getInstance().sharedPreferencesUtil.getString(SharedPreferencesConfig.SHAREDPRE_USERKEY,
                SystemParamCfg.DEFAULT_EMPTY_VALUE));
    }
    
    /**
     * 是否是第一次登录   
     */
    public boolean isFirstLogin()
    {
        return Session.getInstance().sharedPreferencesUtil.getBoolean(Session.getInstance().sharedPreferencesUtil.SHAREDPREFERENCES_FIRST, true);
    }
    
    /**
     * 没有登录，则跳转到登录界面。否则返回true 
     */
    public boolean isLogin(Context context)
    {
        if (TextUtils.isEmpty(getLoginKey()))
        {
            MyFrameCoreTools.getInstance().startActivity(context, LoginActivity.class, null);
            return false;
        }
        return true;
    }
}
