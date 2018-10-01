package com.nihongo.dto.httpdto.entity;

import java.util.List;

import com.nihongo.dto.httpdto.AbstractDTO;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 11:55:58 PM
 *
 */
public class ExamDTO extends AbstractDTO {

	private int topic;
	private String content;
	private List<ExamElement> questions;
	
	public ExamDTO() {

	}

	public ExamDTO(int topic, List<ExamElement> questions, String content) {
		this.topic = topic;
		this.questions = questions;
		this.content = content;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public List<ExamElement> getQuestions() {
		return questions;
	}

	public void setQuestions(List<ExamElement> questions) {
		this.questions = questions;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
