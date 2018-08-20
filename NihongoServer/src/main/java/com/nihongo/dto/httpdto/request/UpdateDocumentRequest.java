package com.nihongo.dto.httpdto.request;

import java.util.List;

/**
 * 
 * @author DoanhNV Aug 8, 2018 3:00:16 PM
 *
 */
public class UpdateDocumentRequest extends AbstractNihongoRequest {

	private String id;
	private String content;
	private int topic;
	private List<String> questionIds;
	private int level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public List<String> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<String> questionIds) {
		this.questionIds = questionIds;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
