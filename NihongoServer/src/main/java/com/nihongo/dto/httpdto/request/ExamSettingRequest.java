package com.nihongo.dto.httpdto.request;

import java.util.List;

import com.nihongo.data.entity.setting.TopicNumber;

/**
 * 
 * @author DoanhNV Aug 21, 2018 4:58:41 PM
 *
 */
public class ExamSettingRequest extends AbstractNihongoRequest {

	private String id;
	private int level;
	private List<TopicNumber> topicConfigs;

	public ExamSettingRequest() {

	}

	public ExamSettingRequest(String id, int level, List<TopicNumber> topicConfigs) {
		this.id = id;
		this.level = level;
		this.topicConfigs = topicConfigs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
