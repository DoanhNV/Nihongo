package com.nihongo.dto.httpdto.response;

import org.json.simple.JSONObject;

import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:57 AM
 */
public class AbstractNihongoResponse {

	protected float code;
	protected String message;

	public AbstractNihongoResponse() {
		this.code = ResponseCode.SUCCESS;
	}
	
	public AbstractNihongoResponse(float code) {
		this.code = code;
	}

	public AbstractNihongoResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}

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

	@SuppressWarnings("unchecked")
	public JSONObject toJson() {
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put(Constant.RESPONSE_PROPERTIES.CODE, this.code);
		jsonResponse.put(Constant.RESPONSE_PROPERTIES.MESSAGE, this.message);
		return jsonResponse;
	}
}
