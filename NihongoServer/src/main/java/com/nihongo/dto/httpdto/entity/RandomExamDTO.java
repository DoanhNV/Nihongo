package com.nihongo.dto.httpdto.entity;

import java.util.List;

import com.nihongo.data.entity.question.Question;
import com.nihongo.dto.httpdto.AbstractDTO;

/**
 * 
 * @author DoanhNV Jul 9, 2018 11:17:19 AM
 */
public class RandomExamDTO extends AbstractDTO {
	
	private int topic;
	private List<Question> questions;

	public RandomExamDTO() {

	}

	public RandomExamDTO(int topic, List<Question> questions) {
		this.topic = topic;
		this.questions = questions;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
