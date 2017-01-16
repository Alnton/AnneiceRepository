package com.alnton.myframe.util.http;

import java.util.concurrent.ConcurrentHashMap;

import com.alnton.myframe.entity.http.RequestEntity;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;

/**
 * 将Http请求中的JsonRequestParams输出Json格式字符串
 * 备注：params.put(key, value) value仅限于String,int,long 三种类型
 * @author  王乾州
 * @createon 2016-9-8
 */
public class JsonRequestParams extends RequestParams
{
    private static final long serialVersionUID = -7938924879346322566L;
    
    @Override
    public String toString()
    {
        Gson gson = new Gson();
        StringBuilder result = new StringBuilder();
        result.append("{");
        
        for (ConcurrentHashMap.Entry<String, String> entry : urlParams.entrySet())
        {
            result.append(",");
            result.append("\"" + entry.getKey() + "\"");
            RequestEntity requestEntity = new RequestEntity(entry.getValue());
            String value = gson.toJson(requestEntity);
            result.append(value.substring(value.indexOf(":"), value.lastIndexOf("}")));
        }
        
        result.append("}");
        
        return result.toString().replaceFirst(",", "");
    }
}