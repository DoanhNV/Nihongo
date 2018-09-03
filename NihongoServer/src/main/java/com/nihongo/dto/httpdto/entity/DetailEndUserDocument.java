package com.nihongo.dto.httpdto.entity;

import java.util.List;

import com.nihongo.data.entity.question.MCQQuestion;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 11:11:46 PM
 *
 */
public class DetailEndUserDocument implements ExamElement {

	private String content;
	private int topic;
	private List<MCQQuestion> questions;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public List<MCQQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MCQQuestion> questions) {
		this.questions = questions;
	}
}
