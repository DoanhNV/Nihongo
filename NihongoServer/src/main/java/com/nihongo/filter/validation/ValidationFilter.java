package com.nihongo.filter.validation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;

/**
 * 
 * @author DoanhNV Aug 20, 2018 11:00:42 PM
 */
public interface ValidationFilter {
	
	public AbstractNihongoResponse validate(String requestBody)  throws JsonParseException, JsonMappingException, IOException;
}
