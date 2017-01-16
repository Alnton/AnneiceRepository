package com.alnton.myframe.ui.pay.alipay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <支付宝支付工具类>
 * @author  王乾州
 */
public class AlipayUtil
{
    private static AlipayUtil alipayUtil;
    
    public static AlipayUtil getInstance()
    {
        if (null == alipayUtil)
        {
            alipayUtil = new AlipayUtil();
        }
        return alipayUtil;
    }
    
    /**
     * 构造支付订单参数列表
     * @param pid       支付宝分配给开发者的应用ID
     * @param tradeNo   商户网站唯一订单号
     * @param money     订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * @param subject   商品的标题/交易标题/订单标题/订单关键字等。
     * @param body      对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
     * @param timestamp 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    public Map<String, String> buildOrderParamMap(String app_id, String tradeNo, String money, String subject,
        String body, String timestamp)
    {
        Map<String, String> keyValues = new HashMap<String, String>();
        
        keyValues.put("app_id", app_id);
        
        keyValues.put("biz_content",
            "{\"timeout_express\":\"30m\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"total_amount\":\"" + money
                + "\",\"subject\":\"" + subject + "\",\"body\":\"" + body + "\",\"out_trade_no\":\"" + tradeNo + "\"}");
        
        keyValues.put("charset", "utf-8");
        
        keyValues.put("method", "alipay.trade.app.pay");
        
        keyValues.put("sign_type", "RSA");
        
        keyValues.put("timestamp", timestamp);
        
        keyValues.put("version", "1.0");
        
        return keyValues;
    }
    
    /**
     * 构造支付订单参数信息
     * 
     * @param map  buildOrderParamMap()返回的Map
     */
    public String buildOrderParam(Map<String, String> map)
    {
        List<String> keys = new ArrayList<String>(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++)
        {
            String key = keys.get(i);
            String value = map.get(key);
            sb.append(buildKeyValue(key, value, true));
            sb.append("&");
        }
        
        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        sb.append(buildKeyValue(tailKey, tailValue, true));
        
        return sb.toString();
    }
    
    /**
     * 拼接键值对
     * 
     * @param key
     * @param value
     * @param isEncode
     * @return
     */
    private static String buildKeyValue(String key, String value, boolean isEncode)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("=");
        if (isEncode)
        {
            try
            {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            }
            catch (UnsupportedEncodingException e)
            {
                sb.append(value);
            }
        }
        else
        {
            sb.append(value);
        }
        return sb.toString();
    }
    
    /**
     * 对支付参数信息进行签名
     * 
     * @param map
     *            待签名授权信息
     * 
     * @return
     */
    public String getSign(Map<String, String> map, String rsaKey)
    {
        List<String> keys = new ArrayList<String>(map.keySet());
        // key排序
        Collections.sort(keys);
        
        StringBuilder authInfo = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++)
        {
            String key = keys.get(i);
            String value = map.get(key);
            authInfo.append(buildKeyValue(key, value, false));
            authInfo.append("&");
        }
        
        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        authInfo.append(buildKeyValue(tailKey, tailValue, false));
        
        String oriSign = SignUtils.sign(authInfo.toString(), rsaKey);
        String encodedSign = "";
        
        try
        {
            encodedSign = URLEncoder.encode(oriSign, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return "sign=" + encodedSign;
    }
}