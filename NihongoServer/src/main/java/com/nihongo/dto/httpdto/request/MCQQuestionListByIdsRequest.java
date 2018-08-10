package com.nihongo.dto.httpdto.request;

import java.util.List;

/**
 * 
 * @author DoanhNV Aug 10, 2018 4:06:26 PM
 *
 */
public class MCQQuestionListByIdsRequest extends AbstractRequest {

	private List<String> questionIds;

	public List<String> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<String> questionIds) {
		this.questionIds = questionIds;
	}
}
