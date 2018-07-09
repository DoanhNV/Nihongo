package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.data.entity.question.Question;

/**
 * 
 * @author DoanhNV Jul 9, 2018 9:13:01 AM
 */
public class MCQQuestionSearchResponse extends AbstractResponse {

	private List<Question> questions;

	public MCQQuestionSearchResponse() {

	}

	public MCQQuestionSearchResponse(float code) {
		this.code = code;
	}

	public MCQQuestionSearchResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
