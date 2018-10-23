package com.nihongo.data.entity.userconnection;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

public class ExamHistory extends AbstractEntity {
	
	private List<String> examIds;

	public List<String> getExamIds() {
		return examIds;
	}

	public void setExamIds(List<String> examIds) {
		this.examIds = examIds;
	}
}
