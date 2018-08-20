package com.nihongo.dto.httpdto.response.file;

import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;

/**
 * 
 * @author DoanhNV Jul 31, 2018 2:16:42 PM
 *
 */
public class LoadBase64Response extends AbstractNihongoResponse {

	private String base64Str;

	public String getBase64Str() {
		return base64Str;
	}

	public void setBase64Str(String base64Str) {
		this.base64Str = base64Str;
	}
	
	public void setResponseData(float code, String base64Str) {
		this.code = code;
		this.base64Str = base64Str;
	}
}
