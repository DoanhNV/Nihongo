package com.nihongo.dto.httpdto.response;

import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Sep 4, 2018 - 10:17:37 PM
 *
 */
public class UpdateExamResponse extends AbstractNihongoResponse {

	public UpdateExamResponse() {
		this.code = ResponseCode.SUCCESS;
	}
	
	public UpdateExamResponse(float code) {
		this.setCode(code);
	}

	public UpdateExamResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}
}
