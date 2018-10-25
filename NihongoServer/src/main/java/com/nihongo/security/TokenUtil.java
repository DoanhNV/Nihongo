package com.nihongo.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.mongo.MongoDBKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 8:50:24 AM
 *
 */
public class TokenUtil {

	public static String createToken(String id, String password, Boolean isAdmin) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Constant.TOKEN.GENERATE_TOKEN_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(Constant.TOKEN.LOGIN_SUBJECT)
				.setIssuer(Constant.TOKEN.ISSUER).signWith(signingKey, signatureAlgorithm);

		builder.claim(MongoDBKey.USER.IS_ADMIN, isAdmin);
		
		/*
		final long BUFFER_EXPIRED_TOKEN = Constant.DATE_TIME.A_DAY;
		long expireMillis = nowMillis + Constant.TOKEN.INTERVAL_EXPIRED_TIME + BUFFER_EXPIRED_TOKEN;
		Date expireDate = new Date(expireMillis);
		builder.setExpiration(expireDate);
		*/
		

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public static Claims parseToken(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(Constant.TOKEN.GENERATE_TOKEN_KEY))
				.parseClaimsJws(jwt).getBody();
		return claims;
	}

	public static boolean isValidToken(String jwt) {
		try {
			Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(Constant.TOKEN.GENERATE_TOKEN_KEY))
				.requireSubject(Constant.TOKEN.LOGIN_SUBJECT)
				.requireIssuer(Constant.TOKEN.ISSUER)
				.parseClaimsJws(jwt);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String getUserId(String jwt) {
		return parseToken(jwt).getId();
	}
}
