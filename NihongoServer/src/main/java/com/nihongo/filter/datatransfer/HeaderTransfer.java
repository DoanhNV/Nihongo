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
	
	public static String tranferParamToBody(String reuqestURI, String accessToken, String requestBody) {
		if(reuqestURI.equals(USER_CONNECTION.ROOT + USER_CONNECTION.LIKE)
				|| reuqestURI.equals(USER_CONNECTION.ROOT + USER_CONNECTION.FAVORITE)
				|| reuqestURI.equals(EXAM.ROOT + EXAM.LIST_FAVORITE)) {
			requestBody = tranferUserIdToBody(accessToken, requestBody);
		}
		return requestBody;
	}
	
	public static String tranferUserIdToBody(String accessToken, String requestBody) {
		Map<String, Object> requestBodyAttribuetMap = jsonParser.parseMap(requestBody);
		Claims tokenClaim = TokenUtil.parseToken(accessToken);
		
		String userId = tokenClaim.getId();
		requestBodyAttribuetMap.put(FilterTransferParam.USER_ID, userId);
		
		JSONObject jsonBody = new JSONObject(requestBodyAttribuetMap);
		return jsonBody.toJSONString();
	}
}
