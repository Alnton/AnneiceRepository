package com.alnton.myframe.entity.pay;

import java.io.Serializable;

/**
 * 支付实体类
 * @author  王乾州
 * @createon 2016-8-19
 */
public class PayInfo implements Serializable
{
    private static final long serialVersionUID = 3459634801282134626L;
 
    /**
     * 交易流水号
     */
    private String serialNumber;
    
    /**
     * 支付金额
     */
    private String totalMoney;  
    
    /**
     * 支付订单编号
     */
    private String payOrderCode;    
    
    /**
     * 订单发送时间
     */
    private String sendTime;    
    
    /**
     * 用户key
     */
    private String userKey; 
    
    /**
     * 商品名称信息
     */
    private String goodsName;
    
    /**
     * 0:可以去支付
     * 1:亲，该订单已经关闭！
     * 2:亲，该订单已经支付！
     * 3:亲，支付过于频繁请稍后再试！
     */
    private String tip;
    
    /**
     * 微信支付prepayId
     */
    private String wechatPrepay;
    
    /**
     * 微信支付noncestr
     */
    private String wechatNoncestr;
    
    /**
     * 微信支付签名
     */
    private String wechatSign;
    
    /**
     * 微信支付时间戳
     */
    private String wechatTimestamp;


    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getTotalMoney()
    {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney)
    {
        this.totalMoney = totalMoney;
    }

    public String getPayOrderCode()
    {
        return payOrderCode;
    }

    public void setPayOrderCode(String payOrderCode)
    {
        this.payOrderCode = payOrderCode;
    }

    public String getSendTime()
    {
        return sendTime;
    }

    public void setSendTime(String sendTime)
    {
        this.sendTime = sendTime;
    }

    public String getUserKey()
    {
        return userKey;
    }

    public void setUserKey(String userKey)
    {
        this.userKey = userKey;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }
    
    public String getTip()
    {
        return tip;
    }

    public void setTip(String tip)
    {
        this.tip = tip;
    }

    public String getWechatPrepay()
    {
        return wechatPrepay;
    }

    public void setWechatPrepay(String wechatPrepay)
    {
        this.wechatPrepay = wechatPrepay;
    }

    public String getWechatNoncestr()
    {
        return wechatNoncestr;
    }

    public void setWechatNoncestr(String wechatNoncestr)
    {
        this.wechatNoncestr = wechatNoncestr;
    }

    public String getWechatSign()
    {
        return wechatSign;
    }

    public void setWechatSign(String wechatSign)
    {
        this.wechatSign = wechatSign;
    }

    public String getWechatTimestamp()
    {
        return wechatTimestamp;
    }

    public void setWechatTimestamp(String wechatTimestamp)
    {
        this.wechatTimestamp = wechatTimestamp;
    } 
}