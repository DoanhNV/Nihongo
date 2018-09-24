package com.nihongo.filter.validation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.service.manager.APIManager;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Aug 20, 2018 11:02:53 PM
 */
public class NihongoFilter {
	
	public static AbstractNihongoResponse validate(String token, String requestBody, String requestURI) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		try {
			response = APIManager.isTokenAPI(requestURI) ? TokenValidatorFilter.validate(token) : response;
			if(response.getCode() == ResponseCode.SUCCESS) {
				Validation validatior = APIManager.getValidateFilter(requestURI);
				response = validatior.validate(requestURI, requestBody);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
