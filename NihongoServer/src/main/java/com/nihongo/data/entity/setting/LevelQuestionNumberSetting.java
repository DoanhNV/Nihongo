package com.nihongo.data.entity.setting;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

public class LevelQuestionNumberSetting extends AbstractEntity {

	private int level;
	private List<TopicQuestionNumberSetting> numberQuestionPerTopic;

	public LevelQuestionNumberSetting() {

	}

	public LevelQuestionNumberSetting(int level, List<TopicQuestionNumberSetting> numberQuestionPerTopic) {
		this.level = level;
		this.numberQuestionPerTopic = numberQuestionPerTopic;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<TopicQuestionNumberSetting> getNumberQuestionPerTopic() {
		return numberQuestionPerTopic;
	}

	public void setNumberQuestionPerTopic(List<TopicQuestionNumberSetting> numberQuestionPerTopic) {
		this.numberQuestionPerTopic = numberQuestionPerTopic;
	}
}
