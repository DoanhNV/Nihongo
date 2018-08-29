package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.data.entity.exam.Exam;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 9:38:21 PM
 *
 */
public class SearchExamResponse extends AbstractSearchResponse {

	private List<Exam> exams;

	public SearchExamResponse() {

	}

	public SearchExamResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public void setResponseData(float code, int total, List<Exam> exams) {
		this.setCode(code);
		this.setTotal(total);
		this.setExams(exams);
	}
}
