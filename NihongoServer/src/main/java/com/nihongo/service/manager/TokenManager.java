package com.nihongo.service.manager;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.pojo.TokenKey;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.support.util.TokenUtil;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 9:56:07 AM
 *
 */
public class TokenManager {

	private static TreeMap<TokenKey, Long> tokens = new TreeMap<TokenKey, Long>();

	public static String createToken(String userId, String password) {
		String token = existsTokenForUserId(tokens, userId);
		boolean isExistTokenForUserId = token != null;
		if(isExistTokenForUserId) {
			return token;
		}
		
		token = TokenUtil.createToken(userId, password);
		long nowMils = System.currentTimeMillis() + Constant.TOKEN.INTERVAL_EXPIRED_TIME;
		TokenKey tokenKey = new TokenKey(userId, token);
		tokens.put(tokenKey, nowMils);
		return token;
	}

	public static boolean isExpiredToken(String token) {
		if(TokenUtil.isValidToken(token)) {
			throw new AbstractNihongoException(ResponseCode.INVALID_TOKEN);
		}
		
		long currentTimeMls = System.currentTimeMillis();
		String userId = TokenUtil.getUserId(token);
		TokenKey tokenKey = new TokenKey(userId, token);
		Long expireTime = tokens.get(tokenKey);
		boolean isExpiredToken = expireTime == null || expireTime < currentTimeMls;

		if (isExpiredToken) {
			removeToken(token);
		} else {
			resetToken(token);
		}
		return isExpiredToken;
	}

	public static void resetToken(String token) {
		String userId = TokenUtil.getUserId(token);
		TokenKey tokenKey = new TokenKey(userId, token);
		Long expiredTime = tokens.get(tokenKey) + Constant.TOKEN.INTERVAL_EXPIRED_TIME;
		tokens.put(tokenKey, expiredTime);
	}

	public static void removeToken(String token) {
		String userId = TokenUtil.getUserId(token);
		TokenKey tokenKey = new TokenKey(userId, token);
		tokens.remove(tokenKey);
	}
	
	/*=======================================================SUPPORT METHODs===================================================================*/
	
	private static String existsTokenForUserId(TreeMap<TokenKey, Long> tokens, String userId) {
		for (Entry<TokenKey, Long> entry : tokens.entrySet()) {
			if (entry.getKey().getUserId().equals(userId)){
				return entry.getKey().getToken();
			}
		}
		return null;
	}
}
