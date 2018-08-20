package com.nihongo.dto.httpdto.response.file;

import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:05:17 PM
 */
public class UploadStreamResponse extends AbstractNihongoResponse {
	
	private String filePath;

	public UploadStreamResponse() {

	}

	public UploadStreamResponse(float code) {
		this.code = code;
	}

	public UploadStreamResponse(float code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setResponseInfo (float code, String filePath) {
		this.code = code;
		this.filePath = filePath;
	}
}
