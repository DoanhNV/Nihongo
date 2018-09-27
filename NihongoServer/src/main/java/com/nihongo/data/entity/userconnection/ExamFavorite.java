package com.nihongo.data.entity.userconnection;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Sep 27, 2018 5:48:11 PM
 *
 */
public class ExamFavorite extends AbstractEntity {

	private String userId;
	private List<String> exams;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getExams() {
		return exams;
	}

	public void setExams(List<String> exams) {
		this.exams = exams;
	}
}
