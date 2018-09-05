package com.nihongo.dto.httpdto.entity;

import java.util.List;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 11:11:46 PM
 *
 */
public class DetailEndUserDocument implements ExamElement {

	private String content;
	private List<DetailEndUserExamQuestion> questions;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<DetailEndUserExamQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<DetailEndUserExamQuestion> questions) {
		this.questions = questions;
	}
}
