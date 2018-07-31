package com.nihongo.service;

import com.nihongo.data.entity.file.DataFile;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:14:44 PM
 */
public interface FileService {
	
	public String upload(DataFile file);
	
	public String loadFile(String filePath);
}
