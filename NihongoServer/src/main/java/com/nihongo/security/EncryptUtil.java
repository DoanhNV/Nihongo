package com.nihongo.security;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.nihongo.support.constant.Constant;

/**
 * 
 * @author DoanhNV Oct 25, 2018 - 9:46:08 PM
 *
 */
public class EncryptUtil {

	private static final String SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";
	private static final String KEY_ALGORITHM = "AES";
	private static final String ENCRYPT_ALGORITHM = "AES/CBC/PKCS5Padding";

	private static final String PASSWORD = "nihongo@encrypt.2018doanh&hung&bang";
	private static final String SALT = "nihongo*salt*doanh*hung*bang";
	private static final int PASSWORD_ITERATION = 500;
	private static final int KEY_SIZE = 256;

	private static byte[] ivBytes;

	private static SecretKeySpec secretKeySpec;

	static {
		generateKey();
	}

	private static void generateKey() {
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
			KeySpec keySpec = new PBEKeySpec( PASSWORD.toCharArray(), SALT.getBytes(Constant.ENCODING.UTF_8),
					PASSWORD_ITERATION, KEY_SIZE);
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String ecrypt(String input) throws Exception {
		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

		ivBytes = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
		byte[] encryptText = cipher.doFinal(input.getBytes(Constant.ENCODING.UTF_8));
		return new Base64().encodeAsString(encryptText) + "@" + ivBytes;
	}

	public static String decrypt(String inputEncryptText) throws Exception {
		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(ivBytes));
		
		byte[] encryptTextBytes = new Base64().decode(inputEncryptText);
		byte[] decryptTextBytes = cipher.doFinal(encryptTextBytes);
		return new String(decryptTextBytes);
	}
}
