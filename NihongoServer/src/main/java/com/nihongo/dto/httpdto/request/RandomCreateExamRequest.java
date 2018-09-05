package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Aug 28, 2018 - 10:11:49 PM
 *
 */
public class RandomCreateExamRequest extends AbstractNihongoRequest {

	private int level;

	public RandomCreateExamRequest() {

	}

	public RandomCreateExamRequest(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
