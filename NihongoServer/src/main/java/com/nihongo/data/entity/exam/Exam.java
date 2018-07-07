package com.nihongo.data.entity.exam;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Jul 7, 2018 3:07:28 PM
 */
public class Exam extends AbstractEntity {
	private String examName;
	private List<String> examTopics;

	public Exam() {

	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public List<String> getExamTopics() {
		return examTopics;
	}

	public void setExamTopics(List<String> examTopics) {
		this.examTopics = examTopics;
	}

}
