package com.nihongo.data.entity.setting;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Aug 21, 2018 4:41:18 PM
 *
 */
public class ExamSetting extends AbstractEntity {

	private int level;
	private List<TopicNumber> topicConfigs;

	public ExamSetting() {

	}

	public ExamSetting(String id, int level, List<TopicNumber> topicConfigs) {
		this.id = id;
		this.level = level;
		this.topicConfigs = topicConfigs;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<TopicNumber> getTopicConfigs() {
		return topicConfigs;
	}

	public void setTopicConfigs(List<TopicNumber> topicConfigs) {
		this.topicConfigs = topicConfigs;
	}
}
