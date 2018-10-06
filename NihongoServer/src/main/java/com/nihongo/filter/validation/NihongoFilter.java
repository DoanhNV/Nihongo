package com.nihongo.filter.validation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.filter.datatransfer.HeaderTransfer;
import com.nihongo.service.manager.APIManager;
import com.nihongo.service.manager.TokenManager;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * 
 * @author DoanhNV Aug 20, 2018 11:02:53 PM
 */
public class NihongoFilter {
	
	public static AbstractNihongoResponse validate(String accessToken, StringBuilder requestBody, String requestURI) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		requestBody = requestBody == null ? new StringBuilder(Constant.STRING_PROPERTIES.EMPTY) : requestBody;
		try {
			response = APIManager.isTokenAPI(requestURI) ? TokenValidatorFilter.validate(accessToken) : response;
			if(response.getCode() == ResponseCode.SUCCESS) {
				String requestBodyString = transferHeaderParamToBody(accessToken, requestBody.toString(), requestURI);
				clearAndReWriteBody(requestBody, requestBodyString);
				
				Validation validatior = APIManager.getValidateFilter(requestURI);
				response = validatior.validate(requestURI, requestBody.toString());
			}
		} catch (ExpiredJwtException e) {
			TokenManager.removeToken(accessToken);
			response.setCode(ResponseCode.EXPIRED_TOKEN);
		} catch (AbstractNihongoException e) {
			response.setCode(e.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}

	
	private static String transferHeaderParamToBody(String accessToken, String requestBody, String requestURI) {
		boolean isHeaderTransferParamAPI = APIManager.isHeaderTransferParamAPI(requestURI);
		if (isHeaderTransferParamAPI) {
			requestBody = HeaderTransfer.tranferParamToBody(requestURI, accessToken, requestBody);
		}
		return requestBody;
	}
	
	private static void clearAndReWriteBody(StringBuilder requestBody, String requestBodyString) {
		requestBody.setLength(0);
		requestBody.append(requestBodyString);
	} 
}
