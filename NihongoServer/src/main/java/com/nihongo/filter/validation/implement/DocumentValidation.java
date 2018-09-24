package com.nihongo.filter.validation.implement;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.dto.httpdto.request.DocumentSearchRequest;
import com.nihongo.dto.httpdto.request.InsertDocumentRequest;
import com.nihongo.dto.httpdto.request.UpdateDocumentRequest;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.filter.validation.Validation;
import com.nihongo.support.constant.API;

/**
 * 
 * @author DoanhNV Aug 20, 2018 11:05:56 PM
 */
public class DocumentValidation implements Validation {
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public AbstractNihongoResponse validate(String requestUri, String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		switch (requestUri) {
			case API.DOCUMENT.ROOT + API.DOCUMENT.CREATE:
				validateResponse = validateCreate(requestBody);
				break;
			case API.DOCUMENT.ROOT + API.DOCUMENT.SEARCH:
				validateResponse = validateSearch(requestBody);
				break;
			case API.DOCUMENT.ROOT + API.DOCUMENT.UPDATE:
				validateResponse = validateUpdate(requestBody);
				break;
			default:
				validateResponse = validateRegexUri(requestUri, requestBody);
				break;
		}
		return validateResponse;
	}
	
	public AbstractNihongoResponse validateRegexUri(String requestUri, String requestBody) {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		return validateResponse;
	}
	
	
	public AbstractNihongoResponse validateCreate(String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		InsertDocumentRequest documentRequest = mapper.readValue(requestBody, InsertDocumentRequest.class);
		return validateResponse;
	}

	public AbstractNihongoResponse validateGetById(String requestBody) {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();

		return validateResponse;
	}

	public AbstractNihongoResponse validateSearch(String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		DocumentSearchRequest documentRequest = mapper.readValue(requestBody, DocumentSearchRequest.class);
		return validateResponse;
	}

	public AbstractNihongoResponse validateUpdate(String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		UpdateDocumentRequest documentRequest = mapper.readValue(requestBody, UpdateDocumentRequest.class);
		return validateResponse;
	}
}
