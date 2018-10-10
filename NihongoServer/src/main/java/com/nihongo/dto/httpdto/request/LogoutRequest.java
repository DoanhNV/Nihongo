package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Oct 10, 2018 - 10:33:14 PM
 *
 */
public class LogoutRequest extends AbstractNihongoRequest {
	
	private String token;
	
	public LogoutRequest() {

	}

	public LogoutRequest(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
