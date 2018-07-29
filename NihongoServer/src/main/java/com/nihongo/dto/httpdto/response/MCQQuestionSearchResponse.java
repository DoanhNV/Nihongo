package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.data.entity.question.MCQQuestion;

/**
 * 
 * @author DoanhNV Jul 9, 2018 9:13:01 AM
 */
public class MCQQuestionSearchResponse extends AbstractSearchResponse {

	private List<MCQQuestion> questions;

	public MCQQuestionSearchResponse() {

	}

	public MCQQuestionSearchResponse(float code) {
		this.code = code;
	}

	public MCQQuestionSearchResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}

	public List<MCQQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MCQQuestion> questions) {
		this.questions = questions;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setResponseData(int code, String message, List<MCQQuestion> questions, int total) {
		this.code = code;
		this.message = message;
		this.questions = questions;
		this.total = total;
	}

	public void setResponseData(float code, List<MCQQuestion> questions, int total) {
		this.code = code;
		this.questions = questions;
		this.total = total;
	}
}
