package com.nihongo.filter.validation;

import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.service.manager.TokenManager;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Aug 20, 2018 11:21:47 PM
 */
public class TokenValidatorFilter {

	public static AbstractNihongoResponse validate(String token) {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		/*boolean isExpiredToken = TokenManager.isExpiredToken(token);
		if(isExpiredToken) {
			response = new AbstractNihongoResponse(ResponseCode.EXPIRED_TOKEN);
		}*/
		return response;
	}
}
