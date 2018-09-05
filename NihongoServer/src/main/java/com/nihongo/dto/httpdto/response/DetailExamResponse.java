package com.nihongo.dto.httpdto.response;

import com.nihongo.dto.httpdto.entity.DetailExam;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 9:33:23 PM
 *
 */
public class DetailExamResponse extends AbstractNihongoResponse {
	
	private DetailExam exam;

	public DetailExam getExam() {
		return exam;
	}

	public void setExam(DetailExam exam) {
		this.exam = exam;
	}
	
	public void setResponseData(float code, DetailExam detailExam) {
		this.setCode(code);
		this.setExam(detailExam);
	}
}
