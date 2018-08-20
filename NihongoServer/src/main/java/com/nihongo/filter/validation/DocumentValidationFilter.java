package com.nihongo.filter.validation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;

/**
 * 
 * @author DoanhNV Aug 20, 2018 11:05:56 PM
 */
public class DocumentValidationFilter implements ValidationFilter {

	@Override
	public AbstractNihongoResponse validate(String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		ObjectMapper mapper = new ObjectMapper();
		Document document = mapper.readValue(requestBody, Document.class);
		return validateResponse;
	}
}
