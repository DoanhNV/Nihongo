package com.nihongo.data.entity.topic;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.questiondocument.Document;

/**
 * 
 * @author DoanhNV Jul 7, 2018 3:16:52 PM
 */
public class ExamTopic extends AbstractEntity {
	private Document document;
	private List<String> questionIds;

	public ExamTopic() {

	}

	public ExamTopic(Document document, List<String> questionIds) {
		this.document = document;
		this.questionIds = questionIds;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<String> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<String> questionIds) {
		this.questionIds = questionIds;
	}

}
