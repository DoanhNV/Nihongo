package com.nihongo.data.entity.questiondocument;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Jul 7, 2018 2:53:23 PM
 */
public class Document extends AbstractEntity {
	
	private String content;
	private int topic;
	private List<String> questionIds;
	private int level;

	public Document() {

	}

	public Document(String id, String content, int topic, int level, List<String> questionIds) {
		this.id = id;
		this.content = content;
		this.topic = topic;
		this.level = level;
		this.questionIds = questionIds;
	}

	public List<String> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<String> questionIds) {
		this.questionIds = questionIds;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}
}
