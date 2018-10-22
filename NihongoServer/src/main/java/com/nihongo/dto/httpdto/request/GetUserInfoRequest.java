package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Oct 20, 2018 - 4:39:53 PM
 *
 */
public class GetUserInfoRequest extends AbstractNihongoRequest {
	
	private String requestUserId;

	public String getRequestUserId() {
		return requestUserId;
	}

	public void setRequestUserId(String requestUserId) {
		this.requestUserId = requestUserId;
	}
}
