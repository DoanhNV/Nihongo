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
	private List<ExamElement> questions;
	
	public ExamDTO() {

	}

	public ExamDTO(int topic, List<ExamElement> questions) {
		this.topic = topic;
		this.questions = questions;
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
}
