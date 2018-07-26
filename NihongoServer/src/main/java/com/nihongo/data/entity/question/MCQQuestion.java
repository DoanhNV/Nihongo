package com.nihongo.data.entity.question;

import java.util.List;

/**
 * 
 * @author DoanhNV Jul 7, 2018 2:55:05 PM
 */
public class MCQQuestion extends Question {
	private String title;
	private String document;
	private List<Answer> answers;
	private int topic;
	private int level;
	private String titleSub;

	public MCQQuestion() {

	}

	public MCQQuestion(String id) {
		this.id = id;
	}

	public MCQQuestion(String title, List<Answer> answers, int topic, int level) {
		this.title = title;
		this.answers = answers;
		this.topic = topic;
		this.level = level;
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

	public String getTitleSub() {
		return titleSub;
	}

	public void setTitleSub(String titleSub) {
		this.titleSub = titleSub;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
}
