package com.nihongo.dto.httpdto.request;

public class HistoryExamRequest extends AbstractNihongoRequest {
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
