package com.bingbing.bingxue.common.util;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.Security;

public class AesUtils {

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    /**
     * 网联敏感字段AES加密
     * @param str   敏感字段原文
     * @param key   AES密钥.getByte()
     * @return
     */
    public static byte[] Aes256Encode(String str, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); // 生成加密解密需要的Key
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    /**
     * 网联敏感字段密文解密
     * @param bytes  要被解密的密文.getByte
     * @param key    AES密钥.getByte
     * @return       解密后的字符串
     */
    public static String Aes256Decode(byte[] bytes, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); // 生成加密解密需要的Key
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decoded = cipher.doFinal(bytes);
            return new String(decoded, "UTF-8");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    /**
     * 网联敏感字段密文解密--主要用于解密对账明细文件
     * @param bytes  要被解密的密文.getByte
     * @param key    AES密钥.getByte
     * @return  解密后的byte数组
     */
    public static byte[] Aes256DecodeToByte(byte[] bytes, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); // 生成加密解密需要的Key
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(bytes);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
}