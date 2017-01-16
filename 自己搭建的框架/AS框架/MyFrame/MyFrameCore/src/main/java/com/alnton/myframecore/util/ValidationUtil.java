package com.alnton.myframecore.util;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <所有的校验工具类>
 * @author  王乾州
 * @createon 2016-9-21
 */
public enum ValidationUtil
{
    /**
     * 单例模式
     */
    instance;
    ValidationUtil()
    {
    }
    
    /**
     * 邮件地址的正则表达式匹配
     */
    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-]{1,256}" + "\\@"
        + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");
    
    /**
     * 密码的正则表达式匹配
     */
    public final Pattern PWD_ADDRESS_PATTERN = Pattern.compile("^(?![0-9]+$)|(?![a-zA-Z]+$)|[0-9A-Za-z]{6,16}$");
    
    /**
     * 邮箱正确性验证
     */
    public boolean isValidEmail(String emailContent)
    {
        return EMAIL_ADDRESS_PATTERN.matcher(emailContent).matches();
    }
    
    /**
     * 密码正确性验证
     * 6-16位数字或字母组合
     */
    public boolean isValidPwd(String pwdContent)
    {
        return PWD_ADDRESS_PATTERN.matcher(pwdContent).matches();
    }
    
    /**
     * 检查是否为合法手机号
     * 
     * @param cellPhone
     * @return
     */
    public boolean isVaildPhone(String cellPhone)
    {
        /*
         * 10. * 移动: 2G号段(GSM网络)有139,138,137,136,135,134,159,158,152,151,150, 11. *
         * 3G号段(TD-SCDMA网络)有157,182,183,188,187,181 147是移动TD上网卡专用号段. 联通: 12. *
         * 2G号段(GSM网络)有130,131,132,155,156 3G号段(WCDMA网络)有186,185 电信: 13. *
         * 2G号段(CDMA网络)有133,153 3G号段(CDMA网络)有189,180 14.
         */
        String YD = "^[1]{1}(([3]{1}[4-9]{1})|([5]{1}[012789]{1})|([8]{1}[12378]{1})|([4]{1}[7]{1}))[0-9]{8}$";
        String LT = "^[1]{1}(([3]{1}[0-2]{1})|([5]{1}[56]{1})|([8]{1}[56]{1}))[0-9]{8}$";
        String DX = "^[1]{1}(([3]{1}[3]{1})|([5]{1}[3]{1})|([8]{1}[09]{1}))[0-9]{8}$";
        
        Matcher YDMatcher = Pattern.compile(YD).matcher(cellPhone);
        Matcher LTMatcher = Pattern.compile(LT).matcher(cellPhone);
        Matcher DXMatcher = Pattern.compile(DX).matcher(cellPhone);
        if (YDMatcher.matches() || LTMatcher.matches() || DXMatcher.matches())
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * 检查是否为合法IP地址
     * @param ipAddress
     * @return
     */
    public boolean isVaildIP(String ipAddress)
    {
        String ip =
            "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.("
                + "25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
    
    /**
     * 检查是否为合法端口号
     * @param port
     * @return
     */
    public boolean isVaildPort(String port)
    {
        String regex = "^([1-9]|[1-9]\\d{1,3}|[1-6][0-5][0-5][0-3][0-5])$";
        return Pattern.matches(regex, port);
    }
    
    /**
     * 检查是否为字母或者数字或者中文
     * @param inputStr
     * @return
     */
    public boolean isNumCharChinese(String inputStr)
    {
        inputStr = Pattern.compile("[0-9]*").matcher(inputStr).replaceAll("");
        inputStr = Pattern.compile("[a-zA-Z]").matcher(inputStr).replaceAll("");
        inputStr = Pattern.compile("[\u4e00-\u9fa5]").matcher(inputStr).replaceAll("");
        
        if (TextUtils.isEmpty(inputStr))
        {
            return true;
        }
        
        return false;
    }
    
}