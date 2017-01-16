package com.alnton.myframe.ui.pay.alipay;

public class AlipayConstants {
    /**
     * 合作身份者id，以2088开头的16位纯数字
     */
    public static final String APP_ID = "2088421655505810";

    /**
     * 收款支付宝账号
     */
    public static final String DEFAULT_SELLER = "xiao66@xiao6.com";

    /**
     * 支付宝支付的通知结果
     */
    public static final String ALIPAY_NOTIFY_URL = "http://221.130.49.237:6270/aquatic_callback_service/aliCallback/backRecv";

    /**
     * 商户私钥，自助生成(将私钥用pkcs8编码后的私钥)
     */
    public static final String PRIVATE_KEY =
            "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMeLz6meHaASJiomPq4+WXbLr114lc6lMy3vmcGfeoib93LE7gR4fflZxCqO2M5UhQibFfh4x5/+ep130SLOQl4sf8nEy/y7mBqt9Mid9ftpuV7oFS/sPcJfu44cESeHFlSVRh2g0XvcW++xiY5JFpNP2h7BbAG+OUKr/U3upm7LAgMBAAECgYAzN2JcgbXO4Pmktd4+sMgbopnnHs0sleA1+Rp4xOsZZxazAXKp+Rc0SeL8nV9uTek7VTrlZHKwUQu9oQQvr8r+llvr5owEiXCUdDnUxuhmj6w2wya/B0s/aG+eF/FSOLL6mdgYmHPI2Jn8l4cVu2V0kOZTvpFoyMX3QyRdu/CekQJBAPgizJVFqdh7S0ehqI254lXDEPTRU1weqOovlgGP1NlzKjTWqhHI5xXOy9yrpx8niKmrqzYgWx0pqEybWYZcbekCQQDN3sncHDcTMBRA9SHZF+Zd7iP0jQwfOOKVgaR/JH/VO/2qb2JC8pXGMEkUeOPam+5KZZhvzro2m3sgTiQwy4KTAkEAuvN1Ek5fTkRujnSlCsrvVVBX2SxRUwmimHbr3Rdh9ceIGDFYB3hHay3YeNU3YAioNbWqlGhCXbGCJN2y0MGY6QJBAKyV0cn5yV4Hl2MhXX/enlwuUOwp9niSOrm1Vk7ULWp4gV6JQ+n17gOY5RsJgZL519l8tD8/IjK3Q5BAkexqH4sCQCztSAtxSB1MxUOSpd9Die3IdGiN4RqvRsnNBd0L+X3F01fHe1iYRD7VOaFdq1L6Rc6aH4SCg9MwRs5KKbNyb9k=";

    /**
     * 支付宝公钥（固定的，支付宝Demo中的原封不动）
     */
    public static final String PUBLIC_KEY =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHi8+pnh2gEiYqJj6uPll2y69deJXOpTMt75nBn3qIm/dyxO4EeH35WcQqjtjOVIUImxX4eMef/nqdd9EizkJeLH/JxMv8u5garfTInfX7able6BUv7D3CX7uOHBEnhxZUlUYdoNF73FvvsYmOSRaTT9oewWwBvjlCq/1N7qZuywIDAQAB";
}