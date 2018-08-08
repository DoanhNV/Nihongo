package com.nihongo.dto.httpdto.response;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:38:16 AM
 */
public class InsertDocumentResponse extends AbstractInsertResponse {
	
	public InsertDocumentResponse() {
		
	}
	
	public InsertDocumentResponse(float code) {
		this.code = code;
	}
	
	public InsertDocumentResponse(float code, String message, String id) {
		this.code = code;
		this.message = message;
		this.id = id;
	}
	
	public void  setInsertDocumentResponse(float code, String id) {
		this.code = code;
		this.id = id;
	}
}
