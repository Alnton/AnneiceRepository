package com.alnton.myframe.util;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.alnton.myFrameCore.util.MyFrameCoreTools;
import com.alnton.myframe.config.Config.URLConfig;
import com.alnton.myframe.entity.http.ResponseEntity;
import com.alnton.myframe.util.http.HttpInterface;
import com.alnton.myframe.util.http.JsonRequestParams;
import com.alnton.myframe.util.http.RequestCallback;
import com.google.gson.reflect.TypeToken;

/**
 * <系统参数工具类>
 * @author  王乾州
 * @createon 2016-9-21
 */
public enum SystemParameterUtil
{
    instance;
    
    /**
     * 图片上传地址
     */
    public static final String UPLOAD_URL = "upload_url";
    
    /**
     * 商铺发货地址条数
     */
    public static final String SHIPMENTS_ADDRESS = "SHIPMENTS_ADDRESS";
    
    /**
     * 用户地址限制条目数
     */
    public static final String ADDRESS_LIMIT = "address_limit";
    
    /**
     * 用户发票限制条目数
     */
    public static final String BILL_LIMIT = "BILL_LIMIT";
    
    /**
     * app第三方登录开关，0为显示第三方登录，1为不显示第三方登录
     */
    public static final String thirdparty_on_off = "thirdparty_on_off";
    
    SystemParameterUtil()
    {
        
    }
    
    /**
     * 查询系统参数  
     * @param context
     * @param parameterKey 查询参数的key
     * @param requestSuccess 查询参数成功的回调
     */
    public void queryParameter(final Context context, String parameterKey, final RequestSuccess requestSuccess)
    {
        
        RequestCallback<String> req =
            new RequestCallback<String>(context, false, false, new TypeToken<ResponseEntity<String>>()
            {
            }.getType())
            {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody)
                {
                    if (statusCode == 200)
                    {
                        super.onSuccess(statusCode, headers, responseBody);
                    }
                    else
                    {
                        ToastUtil.instance.showToast(context, "查询参数失败");
                    }
                }
                
                @Override
                public void onSuccess(String content, Header[] headers, byte[] responseBody)
                {
                    super.onSuccess(content, headers, responseBody);
                    if (null != requestSuccess)
                    {
                        requestSuccess.onSuccess(getInfo(content));
                    }
                }
            };
        req.setOnFailureShowToast(false);
        
        JsonRequestParams params = new JsonRequestParams();
        params.put("parameterKey", parameterKey);
        
        HttpInterface.instance.onPostWithJson(context, URLConfig.SYSTEMPARAMETER, params, req);
    }
    
    /**
     * 得到返回的参数
     * @param info
     * @return
     */
    private String getInfo(String info)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(info);
            return MyFrameCoreTools.getInstance().formatString(jsonObject.getString("info"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return "";
    }
    
    /**
     * 获取参数成功的回调
     * @Author 詹海
     * @Date 2016-9-20 下午4:37:56
     * @UpdateVersion V1.0
     */
    public interface RequestSuccess
    {
        void onSuccess(String info);
    }
}