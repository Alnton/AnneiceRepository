package com.alnton.myFrameCore.util.des;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * <3DES加密工具类>
 * @author  王乾州
 */
public class DesUtil
{
    /**
     * 密钥
     */
    private String secretKey;
    
    /**
     * 向量
     */
    private final static String iv = "01234567";
    
    /**
     * 加解密统一使用的编码方式
     */
    private final static String encoding = "utf-8";
    
    /**
     * <默认构造函数>
     * @param secretKey 密钥文本
     */
    public DesUtil(String secretKey)
    {
        this.secretKey = secretKey;
    }
    
    /**
     * <3DES加密，生成密文>
     * @param plainText 普通文本
     */
    public String encode(String plainText) throws Exception
    {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        return DesBase64.encode(encryptData);
    }
    
    /**
     * <3DES解密，生成明文>
     * @param encryptText 加密文本
     */
    public String decode(String encryptText) throws Exception
    {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        byte[] decryptData = cipher.doFinal(DesBase64.decode(encryptText));
        return new String(decryptData, encoding);
    }
}