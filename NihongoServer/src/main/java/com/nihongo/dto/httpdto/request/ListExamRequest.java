package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Sep 22, 2018 - 5:31:40 PM
 *
 */
public class ListExamRequest extends AbstractNihongoRequest {

	private Integer level;
	private Integer examType;
	private int skip;
	private int take;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getExamType() {
		return examType;
	}

	public void setExamType(Integer examType) {
		this.examType = examType;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getTake() {
		return take;
	}

	public void setTake(int take) {
		this.take = take;
	}
}
