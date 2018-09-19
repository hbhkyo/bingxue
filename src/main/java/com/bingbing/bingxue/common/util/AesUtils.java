package com.bingbing.bingxue.common.util;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.Security;

public class AesUtils {

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

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