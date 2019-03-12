package com.bingbing.bingxue.common.util;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
public class RsaUtils {

		private static final String KEY_ALGORITHM = "RSA";
		private static final int KEY_SIZE = 2048;//设置长度
		private static final String PUBLIC_KEY_NAME = "publicKey";
		private static final String PRIVATE_KEY_NAME = "privateKey";
		public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
		public static final String ENCODE_ALGORITHM = "SHA-256";
		
		/**
		 * 生成公、私钥
		 * 根据需要返回String或byte[]类型
		 * @return
		 */
		private static Map<String, String> createRSAKeys(){
			Map<String, String> keyPairMap = new HashMap<String, String>();
			try {
				KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
				keyPairGenerator.initialize(KEY_SIZE, new SecureRandom());
				KeyPair keyPair = keyPairGenerator.generateKeyPair();
				
				PublicKey publicKey = keyPair.getPublic();
	            PrivateKey privateKey = keyPair.getPrivate();
				//获取公、私钥值
				String publicKeyValue = Base64.getEncoder().encodeToString(publicKey.getEncoded());
				String privateKeyValue = Base64.getEncoder().encodeToString(privateKey.getEncoded());
				//存入
				keyPairMap.put(PUBLIC_KEY_NAME, publicKeyValue);
				keyPairMap.put(PRIVATE_KEY_NAME, privateKeyValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return keyPairMap;
		}
		
		/**
		 * 解码PublicKey
		 * @param key
		 * @return
		 */
		public static PublicKey getPublicKey(String key) {
		    try {
		        byte[] byteKey = Base64.getDecoder().decode(key);
		        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byteKey);
		        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		        return keyFactory.generatePublic(x509EncodedKeySpec);
		 
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return null;
		}
		/**
		 * 解码PrivateKey
		 * @param key
		 * @return
		 */
		public static PrivateKey getPrivateKey(String key) {
		    try {
		        byte[] byteKey = Base64.getDecoder().decode(key);
		        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(byteKey);
		        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		        
		        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    return null;
		}
		
		/**
		 * 签名
		 * @param key	私钥
		 * @param requestData	请求参数
		 * @return
		 */
		public static String sign(String key, String requestData){
			String signature = null;
			byte[] signed = null;
			try {
				PrivateKey privateKey = getPrivateKey(key);
		        
				Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
				sign.initSign(privateKey);
				sign.update(requestData.getBytes());
				signed = sign.sign();
				signature = Base64.getEncoder().encodeToString(signed);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return signature;
		}
		
		
		/**
		 * 验签
		 * @param key	公钥
		 * @param requestData	请求参数
		 * @param signature	签名
		 * @return
		 */
		public static boolean verifySign(String key, String requestData, String signature){
			boolean verifySignSuccess = false;
			try {
				PublicKey publicKey = getPublicKey(key);
				
				Signature verifySign = Signature.getInstance(SIGNATURE_ALGORITHM);
				verifySign.initVerify(publicKey);
				verifySign.update(requestData.getBytes());
				
				verifySignSuccess = verifySign.verify(Base64.getDecoder().decode(signature));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return verifySignSuccess;
		}
		
		 /**
	     * 公钥加密
	     */
	    public static String encrypt(String publicKey,String content){
	        try {
	            Cipher cipher = Cipher.getInstance("RSA");
	            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
	            byte[] encoded = cipher.doFinal(content.getBytes("utf-8"));
	            return Base64.getEncoder().encodeToString(encoded);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return null;
	    }

	    /**
	     * 私钥解密
	     */
	    public static String decrypt(String privateKey,String content){
	        try {
	            Cipher cipher = Cipher.getInstance("RSA");
	            cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(privateKey));
	            byte[] encoded = cipher.doFinal(Base64.getDecoder().decode(content.getBytes("utf-8")));
	            return new String(encoded,"utf-8");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return null;
	    }

		public static void main(String[] args) {
			Map<String, String> keyPairMap = createRSAKeys();
			System.out.println("生成公、私钥："+keyPairMap);
			String publicKey = keyPairMap.get(PUBLIC_KEY_NAME);
			String privateKey = keyPairMap.get(PRIVATE_KEY_NAME);
			privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ0qwfMvCPut7chLYta0qjXlrzbWYqHDWJAbUibOmGU5lRl1yFs2t5g6qHKXwvrNmnB9ma9tL7U7wPI/NjBjgl32jNifCt7EQA9jwcScjaIb9Zk/ChbTyu3sXmadjnMpHGblAxiW58SszY77Kkb0tQZN0Z1HKo+sMKMJoyJU2ZdZAgMBAAECgYB0cbV5I6QYNGk0OQZl5T0m6aHDk1tIVp9LRbK8Jd0rQlqBno5vZj7ofq1HGcHQaHzAU46GNvNd54Ow97yCZXe0T+WlJd9QLe681qghLH7DDguESxfNG9ONgD8D1q9NDA7HzJ5EO79FzUrWe+AiAmgPqUw8CLYL++TkvGEZvSsC8QJBAPJO+pY9Ny6V5sgCY9cILlQ1T+DH/JuEl3PPdtA92W6mAKQysdH53oDMIF4TBuE0hX12YLc2wJjDkz3z8tpOJBcCQQCmDDJ01xIT6NIX/8jtVnfeB1gosQefCci7g2vxvXwUnn2PS+/GMn5eXOV/2PxIVxgvFsZE0nwJvdRWwcZb4JYPAkEApJWWyiPMbp0tQ5+z9yQ8a8BGgHT2lR/ry6MYnfvUy75/4wf4Fpr1UmDUf3HHE4McRQr6SJgtG9aEFem0hCndgwJAF6OQ41Vi+3afwk7l2fP/aJp/EHvza87Gxvs0uNuS+JR/p5DV989kciajfYn0kI/ln36Mh2u3wONHgXpgtN/KPQJBAKXBW4Rti7Wc1pH3Mm/8opM9h8YpX+/TDF2qvwMWujvmCaG/elmkcGR4Tw+3YB/Eepu8JrrCCuA/6z+X++A+dSU=";
			publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdKsHzLwj7re3IS2LWtKo15a821mKhw1iQG1ImzphlOZUZdchbNreYOqhyl8L6zZpwfZmvbS+1O8DyPzYwY4Jd9ozYnwrexEAPY8HEnI2iG/WZPwoW08rt7F5mnY5zKRxm5QMYlufErM2O+ypG9LUGTdGdRyqPrDCjCaMiVNmXWQIDAQAB";
			String str = "alpha=001&beta=002&gamma=003";
			String sign = sign(privateKey, str);
			System.out.println("sign=="+sign);
			boolean  b = verifySign(publicKey, str, sign);
			System.out.println("b=="+b);
			String encry = encrypt(publicKey,str);
			String decry = decrypt(privateKey,encry);
			System.out.println("encry=="+encry);
			System.out.println("decry=="+decry);
		}
}
