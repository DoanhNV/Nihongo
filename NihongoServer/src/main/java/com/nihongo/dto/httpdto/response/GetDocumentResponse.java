package com.nihongo.dto.httpdto.response;

import com.nihongo.data.entity.questiondocument.Document;

/**
 * 
 * @author DoanhNV Aug 8, 2018 2:07:58 PM
 *
 */
public class GetDocumentResponse extends AbstractResponse {
	
	private Document document;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public void setResponseData(float code, Document document) {
		this.code = code;
		this.document = document;
	}
}
