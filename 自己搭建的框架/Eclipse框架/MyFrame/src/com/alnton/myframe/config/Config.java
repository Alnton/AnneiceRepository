package com.alnton.myframe.config;

import com.alnton.myFrameCore.util.TelephoneUtil;

/**
 * <存放变量字段信息>
 * @author  王乾州
 */
public class Config
{
    /**
     * <系统文件目录类>
     */
    public static class FilePathConfig
    {
        /**
         * SD卡目录
         */
        public static final String SDPath = TelephoneUtil.getInstance().getSDPath();
        
        /**
         * 在SD卡创建项目名称的根目录
         */
        public static final String projectFileDirectory = SDPath + "/MyFrame/";
        
        /**
         * 创建日志目录
         */
        public static final String logFileDirectory = projectFileDirectory + "Log/";
        
        /**
         * 创建图片目录
         */
        public static final String imageFileDirectory = projectFileDirectory + "Images/";
        
        /**
         * 创建APK目录
         */
        public static final String apkFileDirectory = projectFileDirectory + "APK/";
    }
    
    /**
     * <接口地址相关参数类>
     */
    public static class URLConfig
    {
        /**
         * 测试环境地址
         */
        /* 基础数据服务器的地址 */
        //        public static String SERVER_BASEDATA_URL = "http://10.108.26.8:8081";
        //        
        //        public static String SERVER_BASEDATA_READ_URL = "http://10.108.26.8:8081/fzjt_aquatic_read";
        //        
        //        public static String SERVER_BASEDATA_WRITE_URL = "http://10.108.26.8:8081/fzjt_aquatic_write";
        //        
        //        /* 订单数据服务器的地址 */
        //        public static String SERVER_ORDER_URL = "http://10.108.26.8:8084/aquatic_order_service";
        //        
        //        /* 支付数据服务器的地址 */
        //        public static String SERVER_PAY_URL = "http://10.108.26.8:8080/aquatic_pay_service";
        //        
        //        /* 图片数据服务器的地址 */
        //        public static String SERVER_UPLOAD_URL = "http://221.130.49.237:6274/fzjt_fileUpload_service/file_upload";
        //        
        //        /* wap服务地址 */
        //        public static String SERVER_WAP = "http://10.108.26.8:8082/fzjt_aquatic_mw";
        
        /**
         * 开发环境地址
         */
        /* 基础数据服务器的地址 */
        //        public static String SERVER_BASEDATA_URL = "http://10.108.26.245:8080";
        //        
        //        public static String SERVER_BASEDATA_READ_URL = "http://10.108.26.245:8080/fzjt_aquatic_read";
        //        
        //        public static String SERVER_BASEDATA_WRITE_URL = "http://10.108.26.245:8080/fzjt_aquatic_write";
        //        
        //        /* 订单数据服务器的地址 */
        //        public static String SERVER_ORDER_URL = "http://10.108.26.246:8080/aquatic_order_service";
        //        
        //        /* 支付数据服务器的地址 */
        //        public static String SERVER_PAY_URL = "http://10.108.26.60:8080/aquatic_pay_service";
        //        
        //        /* 图片数据服务器的地址 */
        //        public static String SERVER_UPLOAD_URL = "http://221.130.49.237:6274/fzjt_fileUpload_service/file_upload";
        //        
        //        /* wap服务地址 */
        //        public static String SERVER_WAP = "http://10.108.26.8:8082/fzjt_aquatic_mw";
        
        /**
         * 预发布环境地址
         */
        /* 基础数据服务器的地址 */
        //        public static String SERVER_BASEDATA_URL = "http://61.147.167.234:8082";
        //        
        //        public static String SERVER_BASEDATA_READ_URL = "http://61.147.167.234:8082/fzjt_aquatic_read";
        //        
        //        public static String SERVER_BASEDATA_WRITE_URL = "http://61.147.167.234:8082/fzjt_aquatic_write";
        //        
        //        /* 订单数据服务器的地址 */
        //        public static String SERVER_ORDER_URL = "http://61.147.167.234:8080/aquatic_order_service";
        //        
        //        /* 支付数据服务器的地址 */
        //        public static String SERVER_PAY_URL = "http://61.147.167.234:8081/aquatic_pay_service";
        //        
        //        /* 图片数据服务器的地址 */
        //        public static String SERVER_UPLOAD_URL = "http://61.147.167.234:8083/fzjt_fileUpload_service/file_upload";
        //        
        //        /* wap服务地址 */
        //        public static String SERVER_WAP = "http://61.147.167.234:8084/fzjt_aquatic_mw";
        
        /**
         * 生产环境地址
         */
        /* 基础数据服务器的地址 */
        public static String SERVER_BASEDATA_URL = "http://aquaticread.xiao6.com";
        
        public static String SERVER_BASEDATA_READ_URL = "http://aquaticread.xiao6.com/fzjt_aquatic_read";
        
        public static String SERVER_BASEDATA_WRITE_URL = "http://aquaticwrite.xiao6.com/fzjt_aquatic_write";
        
        /* 订单数据服务器的地址 */
        public static String SERVER_ORDER_URL = "http://aquaticorder.xiao6.com/aquatic_order_service";
        
        /* 支付数据服务器的地址 */
        public static String SERVER_PAY_URL = "http://aquaticpay.xiao6.com/aquatic_pay_service";
        
        /* 图片数据服务器的地址 */
        public static String SERVER_UPLOAD_URL = "http://aquaticupload.xiao6.com/fzjt_fileUpload_service/file_upload";
        
        /* wap服务地址 */
        public static String SERVER_WAP = "http://aquaticmanager.xiao6.com/fzjt_aquatic_mw";
        
        /**
         * 系统模块接口
         */
        public static final String SYSTEMPARAMETER = SERVER_BASEDATA_WRITE_URL + "/system/parameter";
        
        /**
         * 检查软件是否需要更新
         */
        public static final String CHECK_SOFT_UPDATE_URL = SERVER_BASEDATA_READ_URL + "/system/version";
        
        /**
         * 登陆地址
         */
        public static final String LOGIN_URL = SERVER_BASEDATA_URL + "login.json";
        
        /**
         * 上传异常日志
         */
        public static final String UPLOAD_EXCEPTION_URL = SERVER_BASEDATA_URL + "uploadExceptionLog.json";
        
        /**
         * 首页顶部banner 活动直通车 图片接口
         */
        public static final String HOMEPAGE_PIC_URL = SERVER_BASEDATA_READ_URL + "/query/homePic";
        
        /**
         * 退出登录 
         */
        public static final String LOGOUT_USERACC = SERVER_BASEDATA_WRITE_URL + "/logout/userAcc";
        
        /**
         * 登录接口
         */
        public static final String LOGINRUSER_URL = SERVER_BASEDATA_WRITE_URL + "/login/account";
        
        /**
         * 第三方登录接口
         */
        public static final String LOGIN_THIRD_URL = SERVER_BASEDATA_WRITE_URL + "/login/thirdparty";
        
        /**
         * 银联支付获取交易流水号接口
         */
        public static final String YINLIANPAY_URL = SERVER_PAY_URL + "/callpay/callUnionPay";
        
        /**
         * 微信支付获取交易流水号接口
         */
        public static final String WXPAY_URL = SERVER_PAY_URL + "/callpay/callWechatPay";
        
        /**
         * 支付成功后获取订单信息接口
         */
        public static final String PAYRESULT_URL = SERVER_ORDER_URL + "/order/queryOrderPartInfo";
        
        /**
         * 获取支付方式信息接口
         */
        public static final String PAYTYPE_URL = SERVER_ORDER_URL + "/category/quecatelist";
    }
    
    /**
     * <系统SharedPreferences相关参数类>
     */
    public static class SharedPreferencesConfig
    {
        /**************************** 登录 ****************************/
        /**
         * 记住密码
         */
        public static final String SHAREDPRE_REMEMBER = "sharedpre_remember";
        
        /**
         * 用户名
         */
        public static final String SHAREDPRE_USERNAME = "sharedpre_username";
        
        /**
         * 密码
         */
        public static final String SHAREDPRE_PWD = "sharedpre_pwd";
        
        /**
         * 用户key
         */
        public static final String SHAREDPRE_USERKEY = "sharedpre_userKey";
        
        /**
         * 登陆返回的信息
         */
        public static final String USERINFO = "USERINFO";
        
        /**
         * 本地验证码在第几次后获取短信验证码时显示
         */
        public static final int GRAPHCODE_SHOW_NUM = 2;
        
        /**************************** 登录结束 ****************************/
    }
    
    /**
     * <系统相关参数类>
     */
    public static class SystemParamCfg
    {
        /**
         * 数据错误值
         */
        public static final int INVALIED_VALUE = 2147483647;
        
        /**
         * 无信号值显示的默认值
         */
        public static final String DEFAULT_VALUE = "--";
        
        /**
         * 空默认值
         */
        public static final String DEFAULT_EMPTY_VALUE = "";
    }
}