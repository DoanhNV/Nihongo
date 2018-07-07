package com.nihongo.data.entity.question;

import java.util.List;

/**
 * 
 * @author DoanhNV Jul 7, 2018 2:55:05 PM
 */
public class MCQQuestion extends Question {
	private String title;
	private List<String> anwserIds;
	private int topic;
	private int level;

	public MCQQuestion() {

	}

	public MCQQuestion(String id) {
		this.id = id;
	}

	public MCQQuestion(String title, List<String> anwserIds, int topic, int level) {
		this.title = title;
		this.anwserIds = anwserIds;
		this.topic = topic;
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAnwserIds() {
		return anwserIds;
	}

	public void setAnwserIds(List<String> anwserIds) {
		this.anwserIds = anwserIds;
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

}
