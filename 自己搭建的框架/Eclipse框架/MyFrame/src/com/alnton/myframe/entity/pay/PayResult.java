package com.alnton.myframe.entity.pay;

import java.io.Serializable;

/**
 * 支付结果实体类
 * @author  王乾州
 * @createon 2016-8-19
 */
public class PayResult implements Serializable
{
    private static final long serialVersionUID = 3459634801282134626L;

    /**
     * 订单编号
     */
    private String orderCode;    
    
    /**
     * 收货人姓名
     */
    private String userName;    
    
    /**
     * 联系电话
     */
    private String telephone; 
    
    /**
     * 收货地址
     */
    private String address;
    
    /**
     * 订单金额
     */
    private String orderMoney;
    
    /**
     * 支付方式（1银联2支付宝 3微信） 
     */
    private String payType;

    public String getOrderCode()
    {
        return orderCode;
    }

    public void setOrderCode(String orderCode)
    {
        this.orderCode = orderCode;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getOrderMoney()
    {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney)
    {
        this.orderMoney = orderMoney;
    }

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
    }  
}