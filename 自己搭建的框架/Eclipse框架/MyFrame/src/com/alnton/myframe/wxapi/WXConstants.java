package com.alnton.myframe.wxapi;

/**
 * 微信支付配置文件 
 */
public class WXConstants
{
    /**
     * APP_ID 替换为你的应用从官方网站申请到的合法appId
     */
    public static final String APP_ID = "wx35726c6cd3a87319";
    
    /**
     * 商家向财付通申请的商家id 
     */
    public static final String PARTNER_ID = "1221961601";
    
    /**
     * 应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
     */
    public static final String SECRET = "8037e1aaa2b7b41d024fdeee3ef3d92a";
    
    /**
     * 微信公众平台商户模块和商户约定的密钥
     * 注意：不能hardcode在客户端，建议genPackage这个过程由服务器端完成
     */
    public static final String PARTNER_KEY = "255fec73bdbf8b4db567a1077c204dae";
    
    /**
     * 微信开放平台和商户约定的密钥
     * 注意：不能hardcode在客户端，建议genSign这个过程由服务器端完成
     */
    public static final String APP_SECRET = "abd9601be39af334bec56e4c4d334c46";
    
    /**
     * 微信开放平台和商户约定的支付密钥
     * 注意：不能hardcode在客户端，建议genSign这个过程由服务器端完成
     */
    public static final String APP_KEY =
        "4G2sEupqVM0phVimZn54pPhwSlGCKnzC5FTSAvOm3CvrVw55WwIsHVjpJjXEpk5zzoqcfWIZcyYJtCJQWEwJv20w4aB2ZmzGNTa1H4YnNpb2zvIntaMMuCvFWxwDpATq"; // wx01b80a51b320f553 对应的支付密钥
    
    /**
     * 微信支付的通知结果
     */
    public static final String WX_NOTIFY_URL = "http://weixin.qq.com";
    
    /**
     * 微信登录 通过code 取得accesstoken 和 openID 的地址
     */
    public static final String getTokenByCode = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&secret=" + SECRET + "&appid=" + APP_ID;
    
    /**
     * 获取到token和openID之后，调用此接口得到身份信息
     */
    public static final String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?";
    
    public static class ShowMsgActivity
    {
        public static final String STitle = "showmsg_title";
        
        public static final String SMessage = "showmsg_message";
        
        public static final String BAThumbData = "showmsg_thumb_data";
    }
}