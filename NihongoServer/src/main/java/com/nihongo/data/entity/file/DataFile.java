package com.nihongo.data.entity.file;

import com.nihongo.data.entity.AbstractSingleEntity;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:17:18 PM
 */
public class DataFile extends AbstractSingleEntity {
	private String fileName;
	private String fileExtentTion;
	private int fileType;
	private String base64Stream;
	private String directory;

	public DataFile() {

	}

	public DataFile(String fileName, int fileType, String base64Stream) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.base64Stream = base64Stream;
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

	public String getFileExtentTion() {
		return fileExtentTion;
	}

	public void setFileExtentTion(String fileExtentTion) {
		this.fileExtentTion = fileExtentTion;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

}
