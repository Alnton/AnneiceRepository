package com.alnton.myFrameCore.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * <采用BigDecimal对于加，减，乘，除做一个精确的算法>
 * scale 必须大于等于0  等于0表示取整
 * @author  王乾州
 */
public enum BigDecimalUtil
{
    /**
     * 单例模式
     */
    instance;
    
    /**
     * 数字转换
     */
    private NumberFormat nf;
    
    BigDecimalUtil()
    {
        nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
    }
    
    /**
     * 提供精确四舍五入加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @param scale  保留小数点后几位
     * @return 两个参数的和
     */
    public String add(String value1, String value2, int scale)
    {
        if (scale < 0)
        {
            return "";
        }
        
        String result = String.format("%." + scale + "f", 0.0);
        try
        {
            BigDecimal b1 = new BigDecimal(value1);
            BigDecimal b2 = new BigDecimal(value2);
            
            nf.setMaximumFractionDigits(scale);
            result = nf.format(b1.add(b2).doubleValue());
            
            if (null != result && result.contains("."))
            {
                int length = result.substring(result.indexOf(".") + 1).length();
                if (length < scale)
                {
                    for (int i = 0; i < scale - length; i++)
                    {
                        result = result.concat("0");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 提供精确四舍五入减法运算的sub方法
     * @param value1 被减数
     * @param value2 减数
     * @param scale  保留小数点后几位
     * @return 两个参数的差
     */
    public String sub(String value1, String value2, int scale)
    {
        if (scale < 0)
        {
            return "";
        }
        
        String result = String.format("%." + scale + "f", 0.0);
        try
        {
            BigDecimal b1 = new BigDecimal(value1);
            BigDecimal b2 = new BigDecimal(value2);
            
            nf.setMaximumFractionDigits(scale);
            result = nf.format(b1.subtract(b2).doubleValue());
            
            if (null != result && result.contains("."))
            {
                int length = result.substring(result.indexOf(".") + 1).length();
                if (length < scale)
                {
                    for (int i = 0; i < scale - length; i++)
                    {
                        result = result.concat("0");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 提供精确四舍五入乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @param scale  保留小数点后几位
     * @return 两个参数的积
     */
    public String mul(String value1, String value2, int scale)
    {
        if (scale < 0)
        {
            return "";
        }
        
        String result = String.format("%." + scale + "f", 0.0);
        try
        {
            BigDecimal b1 = new BigDecimal(value1);
            BigDecimal b2 = new BigDecimal(value2);
            
            nf.setMaximumFractionDigits(scale);
            result = nf.format(b1.multiply(b2).doubleValue());
            
            if (null != result && result.contains("."))
            {
                int length = result.substring(result.indexOf(".") + 1).length();
                if (length < scale)
                {
                    for (int i = 0; i < scale - length; i++)
                    {
                        result = result.concat("0");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 提供精确四舍五入的除法运算方法div
     * @param value1 被除数
     * @param value2 除数
     * @param scale  保留小数点后几位
     * @return 两个参数的商
     */
    public String div(String value1, String value2, int scale)
    {
        if (scale < 0)
        {
            return "";
        }
        
        String result = String.format("%." + scale + "f", 0.0);
        try
        {
            BigDecimal b1 = new BigDecimal(value1);
            BigDecimal b2 = new BigDecimal(value2);
            
            nf.setMaximumFractionDigits(scale);
            result = nf.format(b1.divide(b2, scale, BigDecimal.ROUND_HALF_DOWN).doubleValue());
            
            if (null != result && result.contains("."))
            {
                int length = result.substring(result.indexOf(".") + 1).length();
                if (length < scale)
                {
                    for (int i = 0; i < scale - length; i++)
                    {
                        result = result.concat("0");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}