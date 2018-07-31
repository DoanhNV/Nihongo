package com.nihongo.dto.httpdto.request.file;

import com.nihongo.dto.httpdto.request.AbstractRequest;

/**
 * 
 * @author DoanhNV Jul 31, 2018 2:14:53 PM
 *
 */
public class LoadFileBase64Request extends AbstractRequest {

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
