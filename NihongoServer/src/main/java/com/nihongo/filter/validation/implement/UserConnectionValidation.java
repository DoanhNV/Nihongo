package com.nihongo.filter.validation.implement;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.dto.httpdto.request.ExamFavoriteRequest;
import com.nihongo.dto.httpdto.request.ExamLikeRequest;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.filter.validation.Validation;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.support.util.ValidatorUtil;

public class UserConnectionValidation implements Validation {
	private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@Override
	public AbstractNihongoResponse validate(String requestUri, String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		switch (requestUri) {
			case API.USER_CONNECTION.ROOT + API.USER_CONNECTION.LIKE:
				response = validateLikeRequest(requestBody);
				break;
			case API.USER_CONNECTION.ROOT + API.USER_CONNECTION.FAVORITE:
				response = validateFavoriteRequest(requestBody);
				break;
		}
		return response;
	}
	
	
	private AbstractNihongoResponse validateLikeRequest( String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		ExamLikeRequest examlikeRequest = objectMapper.readValue(requestBody, ExamLikeRequest.class);
		
		if (examlikeRequest.getUserId() == null || examlikeRequest.getUserId().isEmpty() || !ValidatorUtil.isValidObjectId(examlikeRequest.getUserId())) {
			response.setCode(ResponseCode.INVALID_USER_ID);
		}
		if (examlikeRequest.getExamId() == null || examlikeRequest.getExamId().isEmpty() || !ValidatorUtil.isValidObjectId(examlikeRequest.getExamId())) {
			response.setCode(ResponseCode.INVALID_EXAM_ID);
		}
		return response;
	}
	
	private AbstractNihongoResponse validateFavoriteRequest( String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		ExamFavoriteRequest examFavoriteRequest = objectMapper.readValue(requestBody, ExamFavoriteRequest.class);
		
		if (examFavoriteRequest.getUserId() == null 
				|| examFavoriteRequest.getUserId().isEmpty() || !ValidatorUtil.isValidObjectId(examFavoriteRequest.getUserId())) {
			response.setCode(ResponseCode.INVALID_USER_ID);
		}
		if (examFavoriteRequest.getExamId() == null 
				|| examFavoriteRequest.getExamId().isEmpty() || !ValidatorUtil.isValidObjectId(examFavoriteRequest.getExamId())) {
			response.setCode(ResponseCode.INVALID_EXAM_ID);
		}
		return response;
	}
}
