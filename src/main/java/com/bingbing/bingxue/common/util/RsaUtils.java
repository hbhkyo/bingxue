package com.bingbing.bingxue.common.util;

import org.apache.commons.codec.binary.Base64;


import javax.crypto.Cipher;

import java.io.ByteArrayInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;

public class RsaUtils {

    public static String sign(String privateKey,String content){
        try {
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initSign(convertPrivateKey(privateKey));
			signature.update(content.getBytes("utf-8"));
			return Base64.encodeBase64String(signature.sign());
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public static boolean vertify(String publicKey,String content,String signStr){
        try {
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initVerify(convertPublicKey(publicKey));
			signature.update(content.getBytes("utf-8"));
			return signature.verify(Base64.decodeBase64(signStr.getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return false;
    }

    public static String encryptByPublicKey(String publicKey,String content){
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, convertPublicKey(publicKey));
            byte[] encoded = cipher.doFinal(content.getBytes("utf-8"));
            return Base64.encodeBase64String(encoded);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    public static String decryptByPrivateKey(String privateKey,String content){
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, convertPrivateKey(privateKey));
            byte[] encoded = cipher.doFinal(Base64.decodeBase64(content.getBytes("utf-8")));
            return new String(encoded,"utf-8");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    public static PrivateKey convertPrivateKey(String keyStr){
        try {
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(keyStr.getBytes("utf-8")));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			return keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    public static PublicKey convertPublicKey(String keyStr){
        try {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
			Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(Base64.decodeBase64(keyStr.getBytes("utf-8"))));
			return certificate.getPublicKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
}