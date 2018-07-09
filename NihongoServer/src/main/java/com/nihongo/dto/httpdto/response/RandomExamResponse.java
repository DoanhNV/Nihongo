package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.dto.httpdto.RandomExamDTO;

/**
 * 
 * @author DoanhNV Jul 9, 2018 11:25:58 AM
 */
public class RandomExamResponse extends AbstractResponse {
	private List<RandomExamDTO> exams;

	public RandomExamResponse() {

	}

	public RandomExamResponse(float code) {
		this.code = code;
	}

	public RandomExamResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}

	public List<RandomExamDTO> getExams() {
		return exams;
	}

	public void setExams(List<RandomExamDTO> exams) {
		this.exams = exams;
	}

}
