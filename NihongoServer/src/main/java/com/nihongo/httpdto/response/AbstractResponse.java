package com.nihongo.httpdto.response;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:57 AM
 */
public abstract class AbstractResponse {
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

}
