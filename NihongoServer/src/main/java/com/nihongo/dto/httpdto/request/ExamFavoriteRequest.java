package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Sep 27, 2018 5:35:56 PM
 *
 */
public class ExamFavoriteRequest extends AbstractNihongoRequest {
	
	private String userId;
	private String examId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}
}
