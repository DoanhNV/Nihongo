package com.nihongo.dto.httpdto.request;

public class DetailExamRequest extends AbstractNihongoRequest {
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
