package com.nihongo.dto.httpdto.response;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:57 AM
 */
public class NihongoResponse {
	
	protected float code;
	protected String message;
	
	public float getCode() {
		return code;
	}

	public void setCode(float code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setCodeAndMessage(float code, String message) {
		this.code = code;
		this.message = message;
	}
}
