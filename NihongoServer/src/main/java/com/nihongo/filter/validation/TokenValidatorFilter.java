package com.nihongo.filter.validation;

import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;

/**
 * 
 * @author DoanhNV Aug 20, 2018 11:21:47 PM
 */
public class TokenValidatorFilter {

	public static AbstractNihongoResponse validate(String token) {
		AbstractNihongoResponse response = new AbstractNihongoResponse();
		return response;
	}
}
