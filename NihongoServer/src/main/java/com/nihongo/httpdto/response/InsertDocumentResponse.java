package com.nihongo.httpdto.response;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:38:16 AM
 */
public class InsertDocumentResponse extends AbstractResponse {
	
	public InsertDocumentResponse() {
		
	}
	
	public InsertDocumentResponse(float code) {
		this.code = code;
	}

	public InsertDocumentResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}
}
