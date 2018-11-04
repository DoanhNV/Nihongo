package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Oct 31, 2018 - 10:48:47 PM
 *
 */
public class DeleteMCQQuestionRequest extends AbstractNihongoRequest {

	private String id;
	private String documentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
}
