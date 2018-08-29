package com.nihongo.data.entity.exam;

import java.util.List;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 8:50:34 PM
 *
 */
public class EmbedExamTopic {

	private int topic;
	private List<String> mcqQuestionIds;

	public EmbedExamTopic() {

	}

	public EmbedExamTopic(int topic, List<String> mcqQuestionIds) {
		this.topic = topic;
		this.mcqQuestionIds = mcqQuestionIds;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public List<String> getMcqQuestionIds() {
		return mcqQuestionIds;
	}

	public void setMcqQuestionIds(List<String> mcqQuestionIds) {
		this.mcqQuestionIds = mcqQuestionIds;
	}
}
