package com.nihongo.data.entity.userconnection;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Sep 27, 2018 4:09:15 PM
 *
 */
public class ExamLike extends AbstractEntity {

	private List<String> examIds;
	
	public ExamLike() {

	}
	
	public ExamLike(List<String> examIds) {
		this.examIds = examIds;
	}

	public List<String> getExamIds() {
		return examIds;
	}

	public void setExamIds(List<String> examIds) {
		this.examIds = examIds;
	}
}
