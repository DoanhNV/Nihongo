package com.nihongo.controller;

import java.util.List;

import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.response.AbstractSearchResponse;

/**
 * 
 * @author DoanhNV Aug 8, 2018 5:08:18 PM
 *
 */
public class DocumentSearchResponse extends AbstractSearchResponse {

	private List<Document> documents;

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	public void setResponseData(float code, int total, List<Document> documents) {
		this.code = code;
		this.total = total;
		this.documents = documents;
	}
}
