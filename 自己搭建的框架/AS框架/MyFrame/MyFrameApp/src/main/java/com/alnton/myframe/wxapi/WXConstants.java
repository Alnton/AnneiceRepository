package com.alnton.myframe.wxapi;

/**
 * 微信支付、登录配置文件
 */
public class WXConstants {
    /**
     * APP_ID 替换为你的应用从官方网站申请到的合法appId
     */
    public static final String APP_ID = "wx35726c6cd3a87319";

    /**
     * 商家向财付通申请的商家id
     */
    public static final String PARTNER_ID = "1381636702";

    /**
     * 应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
     */
    public static final String SECRET = "8037e1aaa2b7b41d024fdeee3ef3d92a";

    /**
     * 微信登录 通过code 取得accesstoken 和 openID 的地址
     */
    public static final String getTokenByCode = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&secret=" + SECRET + "&appid=" + APP_ID;

    /**
     * 获取到token和openID之后，调用此接口得到身份信息
     */
    public static final String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?";
}