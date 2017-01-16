package com.alnton.myframecore.util;

import java.io.ByteArrayOutputStream;

/**
 * <字节工具类>
 * @author  王乾州
 */
public class ByteUtil
{
    private String hexString = "0123456789ABCDEF";
    
    private static ByteUtil byteUtil;
    
    public static ByteUtil getInstance()
    {
        if (null == byteUtil)
        {
            byteUtil = new ByteUtil();
        }
        return byteUtil;
    }
    
    /**
     * <字符串转化为16进制字符串>
     */
    public String stringToHexString(String strPart)
    {
        String hexString = "";
        for (int i = 0; i < strPart.length(); i++)
        {
            int ch = (int)strPart.charAt(i);
            String strHex = Integer.toHexString(ch);
            hexString = hexString + strHex;
        }
        return hexString;
    }
    
    
    
    /**
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public String encode(String str)
    {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++)
        {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }
    
    /**
     * 将16进制数字解码成字符串,适用于所有字符（包括中文）
     */
    public String decode(String bytes)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
        // 将每2位16进制整数组装成一个字节
        for (int i = 0; i < bytes.length(); i += 2)
            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
        return new String(baos.toByteArray());
    }
    
    private byte uniteBytes(byte src0, byte src1)
    {
        byte _b0 = Byte.decode("0x" + new String(new byte[] {src0})).byteValue();
        _b0 = (byte)(_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[] {src1})).byteValue();
        byte ret = (byte)(_b0 | _b1);
        return ret;
    }
    
    /**
     * <16进制字符串转化为字节数组>
     */
    public byte[] HexString2Bytes(String src)
    {
        byte[] ret = new byte[6];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < 6; ++i)
        {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }
    
    
    /**
     * <合并两个byte数组>
     */
    public byte[] byteMerger(byte[] byte_1, byte[] byte_2)
    {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }
}