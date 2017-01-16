package com.alnton.myFrameCore.util.des;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.net.util.Base64;

/*******************************************************************************
 * AES加解密算法
 *
 *         加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
 *         此处使用AES-128-CBC加密模式，key需要为16位。 也是使用<span
 *         style="font-size: 1em; line-height: 1.5;">0102030405060708</span>
 */

public class AES
{
    
    private final static String AES_DEFAULT_KEY = "fuzhongjtrj_2016";
    
    private final static String AES_DEFAULT_CONFIG = "AES/CBC/PKCS5Padding";
    
    private final static String AES_DEFAULT_IV = "0102030405060708";
    
    // 加密
    public static String Encrypt(String sSrc)
        throws Exception
    {
        return Encrypt(sSrc, AES_DEFAULT_KEY);
    }
    
    public static byte[] Encrypt(byte[] sSrc)
        throws Exception
    {
        return EncryptByte(sSrc, AES_DEFAULT_KEY);
    }
    
    public static String Encrypt(String sSrc, String sKey)
        throws Exception
    {
        return Encrypt(sSrc.getBytes(), sKey);
    }
    
    public static String Encrypt(byte[] sSrc, String sKey)
        throws Exception
    {
        return new String(EncryptByte(sSrc, sKey));
    }
    
    public static byte[] EncryptByte(byte[] sSrc, String sKey)
        throws Exception
    {
        if (sKey == null)
        {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16)
        {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(AES_DEFAULT_CONFIG);// "算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(AES_DEFAULT_IV.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc);
        // 此处使用BAES64做转码功能，同时能起到2次加密的作用。
        return Base64.encodeBase64(encrypted);
    }
    
    // 解密
    public static String Decrypt(String sSrc)
        throws Exception
    {
        return Decrypt(sSrc, AES_DEFAULT_KEY);
    }
    
    public static byte[] Decrypt(byte[] sSrc)
        throws Exception
    {
        return DecryptByte(sSrc, AES_DEFAULT_KEY);
    }
    
    public static String Decrypt(String sSrc, String sKey)
        throws Exception
    {
        return Decrypt(sSrc.getBytes(), sKey);
    }
    
    public static String Decrypt(byte[] sSrc, String sKey)
        throws Exception
    {
        byte[] result = DecryptByte(sSrc, sKey);
        return result == null ? null : new String(result);
    }
    
    public static byte[] DecryptByte(byte[] sSrc, String sKey)
        throws Exception
    {
        try
        {
            // 判断Key是否正确
            if (sKey == null)
            {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16)
            {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(AES_DEFAULT_CONFIG);
            IvParameterSpec iv = new IvParameterSpec(AES_DEFAULT_IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64.decodeBase64(sSrc);// 先用bAES64解密
            try
            {
                byte[] original = cipher.doFinal(encrypted1);
                return original;
            }
            catch (Exception e)
            {
                System.out.println("AES 解密字节数据出错：" + e.toString());
                e.printStackTrace();
                return null;
            }
        }
        catch (Exception ex)
        {
            System.out.println("BASE64 解密字节数组出错：" + ex.toString());
            ex.printStackTrace();
            return null;
        }
    }
    
    // test
    public static void main(String[] args)
    {
        try
        {
            String key = "1234567812345678";
            String str = "abc123测试";
            str = URLEncoder.encode(str, "utf-8");
            String s1 = Encrypt(str, key);
            String s2 = Decrypt(s1, key);
            s2 = URLDecoder.decode(s2, "utf-8");
            System.out.println("s1=>" + s1 + "; s2=>" + s2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}