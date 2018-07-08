package com.nihongo.httpdto.request.file;

import com.nihongo.httpdto.request.AbstractRequest;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:02:13 PM
 */
public class UploadStreamRequest extends AbstractRequest {
	private String base64Stream;
	private String fileName;
	private int fileType;

	public UploadStreamRequest() {

	}

	public UploadStreamRequest(String base64Stream, String fileName, int fileType) {
		this.base64Stream = base64Stream;
		this.fileName = fileName;
		this.fileType = fileType;
	}

	public String getBase64Stream() {
		return base64Stream;
	}

	public void setBase64Stream(String base64Stream) {
		this.base64Stream = base64Stream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

}
