package com.nihongo.data.entity.setting;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Jul 19, 2018 5:27:03 PM
 *
 */
public class TopicQuestionNumberSetting extends AbstractEntity {
	private int topic;
	private int questionNumber;

	public TopicQuestionNumberSetting() {

	}

	public TopicQuestionNumberSetting(int topic, int questionNumber) {
		this.topic = topic;
		this.questionNumber = questionNumber;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

}
