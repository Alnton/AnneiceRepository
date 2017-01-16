﻿/*
 * Copyright (C) 2010 The MobileSecurePay Project
 * All right reserved.
 * author: shiqun.shi@alipay.com
 * 
 *  提示：如何获取安全校验码和合作身份者id
 *  1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *  2.点击“商家服务”(https://b.alipay.com/order/myorder.htm)
 *  3.点击“查询合作者身份(pid)”、“查询安全校验码(key)”
 */
package com.alnton.myframe.ui.pay.alipay;

// 请参考 Android平台安全支付服务(msp)应用开发接口(4.2 RSA算法签名)部分，并使用压缩包中的openssl RSA密钥生成工具，生成一套RSA公私钥。
// 这里签名时，只需要使用生成的RSA私钥。
// Note: 为安全起见，使用RSA私钥进行签名的操作过程，应该尽量放到商家服务器端去进行。
public final class Keys
{
    /**
     * 合作身份者id，以2088开头的16位纯数字
     */
    public static final String DEFAULT_PARTNER = "2088901465028412";
    
    /**
     * 收款支付宝账号
     */
    public static final String DEFAULT_SELLER = "41965073@qq.com";
    
    /**
     * 支付宝支付的通知结果
     */
    public static final String ALIPAY_NOTIFY_URL = "http://wx.izouzou.com/travel_b2c/notifyAppPay.action";
    
    /**
     * 商户私钥，自助生成(将私钥用pkcs8编码后的私钥)
     */
    public static final String PRIVATE = 
        "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKdqI0o6jCMJDiOeuNBSshv0Xr22XHoNqCFfeTndf2G6LGwG4/tfWhzNPCt13mRV53rQ7Z6BCjbQImKyLK9GddSPXNgx2mzNhebjZOY9oR9RI8Ploau8s62gBdFWa3oFuFXJqubl6j0rxbomNorBNeF2L7vEmT7UtAxR0OVUnIlbAgMBAAECgYB7Qo4RDOI4uWYLm8T+vKQeKOHIVAfqZTuwtpaOoCI1Vdl2/+vDHAVAx2rRpMrEnOr9Ze5NkTxv9vYaLIzxz7LYSIO5Es+vQ7qQ+EyOSJNsJd1S6ORnFnxkAfv0s3vTD441d5KSQ9+FKdVb2pEQPizLvdjZ2xavwJoCgC6qNtN/gQJBANIl/xpU5EtY3Q08zfSmaFVif5oJyVl9WbKw0iX1UKkiNc6OnYXdWDvHNRtOXARmSkBuUviuq4lYFwSNqTTts9ECQQDL8TXhwzFwJhhbvZF/qMB76AOOgni1UpULZ1bsdriXeHOFqw7VCY6UDCgMbhlkb/RcNNuxPMuUJBtcv5qTGZFrAkEAoxrent9YuaplF4skB0jJHcxvYW1LG+wQnIJk+RUn374vqPxEAsxDWVJKQ8FT5g5Gfy+hsmZPuS/n3Z7dv7jmoQJAN4DSFTs2PTtg7bbN3lxi5lXigepoR5DOF2hsc7Zrzm1tozdGthv/vbMBQ0DDkF4XtvB7yeSt0wdwmvFadCZFOQJAVn5fp8CJPjsWZxo1xQ+6uUI8JCLQwaP49sJwM4QtroQ8cJbQVywpexSAGp2xzLQqNj/jwPaVaf0zN2o0i9I1LQ==";
    
    /**
     * 支付宝公钥（固定的，支付宝Demo中的原封不动）
     */
    public static final String PUBLIC =
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
}