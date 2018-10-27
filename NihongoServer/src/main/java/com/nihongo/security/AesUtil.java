package com.nihongo.security;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.tomcat.util.codec.binary.Base64;

import com.nihongo.support.constant.Constant;

public class AesUtil {
	
	private static final int KEY_SIZE = 128;
	private static final int ITERATION_COUNT = 1000;
	private static final String PASS_PHRASE = "nihongo@%H%^%FSDF2SVC25B6CVCB*(--2bb2fg91";
	private static final String SALT = "577bd45a17977269694908d80905c32a";
	private static final String FOUR = "9a2b73d130c8796309b776eeb09834b0";
	
	private static final String KEY_ALGORITHM = "PBKDF2WithHmacSHA1";
	private static final String SECRET_KEY_ALGORITHM = "AES";
	private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
	
	private static Cipher cipher;
	private static AesUtil aesUtil = new AesUtil();
	
	public static AesUtil getInstance() {
		return aesUtil;
	}
	
	static {
		try {
			cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		} catch (Exception e) {
			throw fail(e);
		}
	}

	public String encrypt(String plaintext) {
		try {
			SecretKey key = generateKey(SALT, PASS_PHRASE);
			byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, FOUR, plaintext.getBytes("UTF-8"));
			return base64(encrypted);
		} catch (Exception e) {
			throw fail(e);
		}
	}

	public String decrypt(String ciphertext) {
		try {
			SecretKey key = generateKey(SALT, PASS_PHRASE);
			byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, FOUR, base64(ciphertext));
			return new String(decrypted, Constant.ENCODING.UTF_8);
		} catch (Exception e) {
			throw fail(e);
		}
	}

	private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {
		try {
			cipher.init(encryptMode, key, new IvParameterSpec(hex(iv)));
			return cipher.doFinal(bytes);
		} catch (Exception e) {
			throw fail(e);
		}
	}

	private SecretKey generateKey(String salt, String passphrase) {
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), ITERATION_COUNT, KEY_SIZE);
			SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), SECRET_KEY_ALGORITHM);
			return key;
		} catch (Exception e) {
			throw fail(e);
		}
	}

	public static String base64(byte[] bytes) {
		return new String(Base64.encodeBase64(bytes));
	}

	public static byte[] base64(String str) {
		return Base64.decodeBase64(str.getBytes());
	}

	public static String hex(byte[] bytes) {
		return new String(Hex.encodeHex(bytes));
	}

	public static byte[] hex(String str) throws DecoderException {
		return Hex.decodeHex(str.toCharArray());
	}

	private static IllegalStateException fail(Exception e) {
	        return new IllegalStateException(e);
	}
}
