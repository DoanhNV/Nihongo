package com.nihongo.dto.httpdto.response;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:15:35 PM
 */
public class InsertMCQQuestionResponse extends AbstractResponse {

	public InsertMCQQuestionResponse() {

	}

	public InsertMCQQuestionResponse(float code) {
		this.code = code;
	}

	public InsertMCQQuestionResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}
}
