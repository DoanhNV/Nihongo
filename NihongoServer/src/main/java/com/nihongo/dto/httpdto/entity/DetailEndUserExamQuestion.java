package com.nihongo.dto.httpdto.entity;

import java.util.List;

import com.nihongo.data.entity.question.Answer;
import com.nihongo.dto.httpdto.AbstractDTO;

/**
 * 
 * @author DoanhNV Sep 4, 2018 - 9:19:38 PM
 *
 */
public class DetailEndUserExamQuestion extends AbstractDTO implements ExamElement {

	private String title;
	private String document;
	private List<Answer> answers;
	private String titleSub;

	public DetailEndUserExamQuestion() {

	}

	public DetailEndUserExamQuestion(String title, String document, List<Answer> answers, String titleSub) {
		this.title = title;
		this.document = document;
		this.answers = answers;
		this.titleSub = titleSub;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getTitleSub() {
		return titleSub;
	}

	public void setTitleSub(String titleSub) {
		this.titleSub = titleSub;
	}
}
