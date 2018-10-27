package com.nihongo.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.nihongo.support.constant.Constant;

public class Encrypt2 {

	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'A', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p' };

	public static String encrypt(String Data) throws Exception {
		System.out.println(new Base64().encodeAsString(keyValue));
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes(Constant.ENCODING.UTF_8));
		String encryptedValue = new Base64().encodeAsString(encVal);
		return encryptedValue;
	}
	
	public static String decrypt(String input) throws Exception {
		Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALGO);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] encryptTextBytes = new Base64().decode(input);
		byte[] decryptBytes = cipher.doFinal(encryptTextBytes);
		return new String(decryptBytes);
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
	
	public static void main(String[] args) throws Exception {
		String name = "doanh";
		
		String encrypt = encrypt(name);
		System.out.println(encrypt);
		String decrypt = decrypt("U2FsdGVkX19tx5FE4lyRc7T/AjpHmVqIxnsydSkXrPQ=");
		System.out.println(decrypt);
	}
}
