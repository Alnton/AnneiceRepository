package com.alnton.myframe.config;

/**
 * <配置文件工具类>
 * @author  王乾州
 */
public class FusionCode
{
    private static FusionCode instance;
    
    public static FusionCode getInstance()
    {
        if (null == instance)
        {
            instance = new FusionCode();
        }
        return instance;
    }
    
    /**
     * 所有上传图片的地方都限制在5M之内
     */
    public final int PIC_MAXSIZE = 5;
    
    /**
     * 切换城市handler what
     */
    public final int HANDLER_CHANGE_CITY = 0x3;
    
    /**
     * 支付成功后更新代付款列表的广播Action
     */
    public final String PAYSUCCESSUPDATETAB_ACTION = "paysuccessupdatetab_action";
    
    /**
     * 展示网页的进度的广播
     */
    public final String HAPPY_URL_RECEIVER = "com.qzhousoft.happyurl_receiver";
    
    /**
     * 扫一扫二维码回调
     */
    public static final int REQUEST_CODE_SCAN = 0x2016;
    public final String DECODED_CONTENT_KEY = "codedContent";
    public final String DECODED_BITMAP_KEY = "codedBitmap";
}