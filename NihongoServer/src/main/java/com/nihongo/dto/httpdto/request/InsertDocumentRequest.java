package com.nihongo.dto.httpdto.request;

import java.util.List;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:40:35 AM
 */
public class InsertDocumentRequest extends AbstractRequest {

	private String content;
	private int topic;
	private int level;
	private List<String> questionIds;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<String> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<String> questionIds) {
		this.questionIds = questionIds;
	}
}
