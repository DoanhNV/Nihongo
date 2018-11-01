package com.nihongo.dto.httpdto.response;

import com.nihongo.data.entity.question.MCQQuestion;

/**
 * 
 * @author DoanhNV Nov 1, 2018 - 10:26:45 PM
 *
 */
public class MCQQuestionDetailResponse extends AbstractNihongoResponse {
	
	private MCQQuestion question;
	
	public MCQQuestionDetailResponse() {

	}
	
	public MCQQuestionDetailResponse(MCQQuestion question) {
		this.question = question;
	}

	public MCQQuestion getQuestion() {
		return question;
	}

	public void setQuestion(MCQQuestion question) {
		this.question = question;
	}
}
