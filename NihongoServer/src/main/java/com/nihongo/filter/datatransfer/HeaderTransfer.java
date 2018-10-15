package com.nihongo.filter.datatransfer;

import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import com.nihongo.support.constant.API.*;
import com.nihongo.support.constant.FilterTransferParam;
import com.nihongo.support.util.TokenUtil;

import io.jsonwebtoken.Claims;


/**
 * 
 * @author DoanhNV Oct 4, 2018 - 7:52:41 PM
 *
 */
public class HeaderTransfer {
	
	private static JsonParser jsonParser = JsonParserFactory.getJsonParser();
	
	public static String tranferParamToBody(String requestURI, String accessToken, String requestBody) {
		if(requestURI.equals(USER_CONNECTION.ROOT + USER_CONNECTION.LIKE)
				|| requestURI.equals(USER_CONNECTION.ROOT + USER_CONNECTION.FAVORITE)
				|| requestURI.equals(EXAM.ROOT + EXAM.LIST_FAVORITE)
				|| requestURI.equals(EXAM.ROOT + EXAM.LIST)) {
			requestBody = tranferUserIdToBody(accessToken, requestBody);
		} else if (requestURI.equals(USER.ROOT + USER.LOGOUT)) {
			requestBody = transferTokenToBody(accessToken);
		}
		return requestBody;
	}
	
	private static String tranferUserIdToBody(String accessToken, String requestBody) {
		Map<String, Object> requestBodyAttribuetMap = jsonParser.parseMap(requestBody);
		Claims tokenClaim = TokenUtil.parseToken(accessToken);
		
		String userId = tokenClaim.getId();
		requestBodyAttribuetMap.put(FilterTransferParam.USER_ID, userId);
		
		JSONObject jsonBody = new JSONObject(requestBodyAttribuetMap);
		return jsonBody.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	private static String transferTokenToBody(String accessToken) {
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put(FilterTransferParam.TOKEN, accessToken);
		return jsonRequest.toJSONString();
	} 
}
