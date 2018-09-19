package com.bingbing.bingxue.common.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {
	
	
	/**
	 * Base64加密
	 * @param plaintext
	 * @return ciphertext
	 */
	public static String encode(String plaintext){
		try {
			return new Base64().encodeToString(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	
	/**
	 * Base64解密
	 * @param ciphertext
	 * @return plaintext
	 */
	public static String decode(String ciphertext){
		try {
			return new String(Base64.decodeBase64(ciphertext),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
