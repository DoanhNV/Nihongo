package com.nihongo.filter.validation.implement;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.filter.validation.Validation;

/**
 * 
 * @author DoanhNV Sep 24, 2018 12:59:12 PM
 *
 */
public class SettingValidation implements Validation {

	@Override
	public AbstractNihongoResponse validate(String requestUri, String requestBody) throws JsonParseException, JsonMappingException, IOException {
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		return validateResponse;
	}

}
