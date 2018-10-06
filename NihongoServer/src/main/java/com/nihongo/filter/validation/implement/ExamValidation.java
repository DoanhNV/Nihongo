package com.nihongo.filter.validation.implement;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.dto.httpdto.request.ListExamRequest;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.filter.validation.Validation;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;
import static com.nihongo.support.util.ValidatorUtil.*;

/**
 * 
 * @author DoanhNV Sep 24, 2018 1:02:50 PM
 *
 */
public class ExamValidation implements Validation {
	
	private ObjectMapper jsonMapper = new ObjectMapper();

	@Override
	public AbstractNihongoResponse validate(String requestUri, String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();

		switch (requestUri) {
			case API.EXAM.ROOT + API.EXAM.LIST:
				validateResponse = validateListForClient(requestBody);
				break;
			case API.EXAM.ROOT + API.EXAM.LIST_FAVORITE:
				break;
			case API.EXAM.ROOT + API.EXAM.SEARCH:
				break;
			case API.EXAM.ROOT + API.EXAM.CREATE_RANDOM_EXAM:
				break;
			default:
				validateResponse = validateGetRequest(requestUri);
				break;
		}
		return validateResponse;
	}

	private AbstractNihongoResponse validateListForClient(String requestBody) throws JsonParseException, JsonMappingException, IOException {
		ListExamRequest request = jsonMapper.readValue(requestBody, ListExamRequest.class);
		float code = ResponseCode.SUCCESS;
		final int queryAll = Constant.QUERY_PROPERTIES.QUERY_ALL;
		final boolean isOutOfExamTypeRange = request.getExamType() != null 
												&& (request.getExamType() < queryAll || Constant.EXAM_TYPE.BEST_TAKED <  request.getExamType());
		final boolean isOutOfLevelRange = request.getLevel() != null 
												&& (request.getLevel() < queryAll || Constant.LEVEL.N5 <  request.getLevel());
		if (isOutOfExamTypeRange) {
			code = ResponseCode.OUT_OF_EXAM_TYPE_RANGE;
		} else if (isOutOfLevelRange) {
			code = ResponseCode.OUT_OF_LEVEL_RANGE;
		}
		return new AbstractNihongoResponse(code);
	}
	
	private AbstractNihongoResponse validateGetDetail(String requestUri) throws JsonParseException, JsonMappingException, IOException {
		float code = ResponseCode.SUCCESS;
		
		String slashRegex = "/";
		String[] params = requestUri.split(slashRegex);
		String userId = params[3];
		Integer clientQueryMode = params[4] == null ? null :  Integer.parseInt(params[4]);
		
		if (userId == null || clientQueryMode == null) {
			code = ResponseCode.INVALID_PARAMS;
		} else if (!(clientQueryMode == Constant.CLIENT_QUERY_MODE.BACKEND_MODE 
												|| clientQueryMode == Constant.CLIENT_QUERY_MODE.END_USER_MODE)) {
			code = ResponseCode.INVALID_CLIENT_QUERY_MODE;
		} else if (!isValidObjectId(userId)){
			code = ResponseCode.INVALID_ID;
		}
		
		return new AbstractNihongoResponse(code);
	}
	
	public AbstractNihongoResponse validateGetRequest (String requestUri) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		if(requestUri.contains(API.EXAM.ROOT + API.EXAM.DETAIL_ALIAS)) {
			response = validateGetDetail(requestUri);
		}
		return response;
	}
	
}