package com.nihongo.dto.httpdto.request;

import java.util.List;

import com.nihongo.data.entity.question.Answer;

public class UpdateMCQQuestionRequest extends AbstractNihongoRequest {

	private String id;
	private String title;
	private String document;
	private List<Answer> answers;
	private int topic;
	private int level;
	private String titleSub;

	public UpdateMCQQuestionRequest() {

	}

	public UpdateMCQQuestionRequest(String id) {
		this.id = id;
	}

	public UpdateMCQQuestionRequest(String title, List<Answer> answers, int topic, int level) {
		this.title = title;
		this.answers = answers;
		this.topic = topic;
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getTitleSub() {
		return titleSub;
	}

	public void setTitleSub(String titleSub) {
		this.titleSub = titleSub;
	}
}
