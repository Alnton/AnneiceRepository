package com.alnton.myframe.entity.http;

import java.io.Serializable;

/**
 * <接口请求的报文，为了解决换行等特殊字符 服务器转换不了>
 * @author  王乾州
 * @createon 2016-8-8
 */
public class RequestEntity implements Serializable
{
    private static final long serialVersionUID = -3679543314486829436L;
    
    /**
     * 请求的内容
     */
    private String value;
    
    public RequestEntity(String value)
    {
        this.setValue(value);
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}