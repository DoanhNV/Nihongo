package com.nihongo.filter.validation.implement;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.dto.httpdto.request.LoginRequest;
import com.nihongo.dto.httpdto.request.RegisterRequest;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.filter.validation.Validation;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.support.constant.API.*;
import com.nihongo.support.constant.Constant;

/**
 * 
 * @author DoanhNV Sep 24, 2018 1:03:25 PM
 *
 */
public class UserValidation implements Validation {
	
	private ObjectMapper jsonMapper = new ObjectMapper();

	@Override
	public AbstractNihongoResponse validate(String requestUri, String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();

		switch (requestUri) {
			case USER.ROOT + USER.REGISTER:
				validateResponse = validateRegister(requestBody);
				break;
			case USER.ROOT + USER.LOGIN:
				validateResponse = validateLogin(requestBody);
				break;
		}
		return validateResponse;
	}

	public AbstractNihongoResponse validateRegister(String requestBody) throws JsonParseException, JsonMappingException, java.io.IOException {
		RegisterRequest request = jsonMapper.readValue(requestBody, RegisterRequest.class);
		float code = ResponseCode.SUCCESS;
		
		if(request.getUserName() == null || request.getUserName().isEmpty()
						|| request.getPassword() == null || request.getPassword().isEmpty()
						|| request.getFullName() == null || request.getFullName().isEmpty()) {
			code = ResponseCode.INVALID_PARAMS;
		} else if(request.getLevel() <  Constant.LEVEL.BEGINER || Constant.LEVEL.N5 < request.getLevel()) {
			code = ResponseCode.OUT_OF_LEVEL_RANGE;
		}
		return new AbstractNihongoResponse(code);
	}

	public AbstractNihongoResponse validateLogin(String requestBody) throws JsonParseException, JsonMappingException, IOException {
		LoginRequest request = jsonMapper.readValue(requestBody, LoginRequest.class);
		float code = ResponseCode.SUCCESS;
		boolean isSocialNetWorkLogin = request.getLoginType() != Constant.LOGIN_TYPE.BY_USER_NAME;
		boolean isEmptyFullName = request.getFullName() == null || request.getFullName().isEmpty();
		if(request.getLoginAlias() == null || request.getLoginAlias().isEmpty()
						|| request.getPassword() == null || request.getPassword().isEmpty()
						|| (isSocialNetWorkLogin && isEmptyFullName)) {
			
			code = ResponseCode.INVALID_PARAMS;
		} else if(isSocialNetWorkLogin && (request.getLevel() <  Constant.LEVEL.BEGINER || Constant.LEVEL.N5 < request.getLevel())) {
			code = ResponseCode.OUT_OF_LEVEL_RANGE;
		} else if(request.getLoginType() < Constant.LOGIN_TYPE.BY_USER_NAME || Constant.LOGIN_TYPE.BY_FACEBOOK < request.getLoginType()) {
			code = ResponseCode.OUT_OF_LOGIN_TYPE_RANGE;
		}
		return new AbstractNihongoResponse(code);
	}
}