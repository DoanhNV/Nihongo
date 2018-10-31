package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Oct 31, 2018 - 10:48:47 PM
 *
 */
public class DeleteMCQQuestionRequest extends AbstractNihongoRequest {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
