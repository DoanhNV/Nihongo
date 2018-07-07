package com.nihongo.data.entity.question;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Jul 7, 2018 3:01:10 PM
 */
public class Answer extends AbstractEntity {
	private String content;
	private boolean isCorrect;

	public Answer() {

	}

	public Answer(String content, boolean isCorrect) {
		this.content = content;
		this.isCorrect = isCorrect;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}