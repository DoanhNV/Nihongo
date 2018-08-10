package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.data.entity.question.MCQQuestion;

/**
 * 
 * @author DoanhNV Aug 10, 2018 4:10:52 PM
 *
 */
public class MCQQuestionListByIdsResponse extends AbstractSearchResponse {
	
	private List<MCQQuestion> questions;
	
	public MCQQuestionListByIdsResponse() {

	}
	
	public MCQQuestionListByIdsResponse(float code) {
		this.code = code;
	}
	
	public List<MCQQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MCQQuestion> questions) {
		this.questions = questions;
	}

	public void setResponseData(float code, List<MCQQuestion> questions, int total) {
		this.code = code;
		this.questions = questions;
		this.total = total;
	}
}
