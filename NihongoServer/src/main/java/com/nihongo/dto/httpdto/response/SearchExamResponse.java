package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.dto.httpdto.entity.BasicExam;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 9:38:21 PM
 *
 */
public class SearchExamResponse extends AbstractSearchResponse {

	private List<BasicExam> exams;

	public SearchExamResponse() {

	}

	public SearchExamResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}

	public List<BasicExam> getExams() {
		return exams;
	}

	public void setExams(List<BasicExam> exams) {
		this.exams = exams;
	}

	public void setResponseData(float code, int total, List<BasicExam> exams) {
		this.setCode(code);
		this.setTotal(total);
		this.setExams(exams);
	}
}
