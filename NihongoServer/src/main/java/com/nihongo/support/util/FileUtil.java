package com.nihongo.support.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;

import com.nihongo.exception.DataFileException;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:38:32 PM
 */
public class FileUtil {
	
	public static void writeFile(File desFile, String base64String) {
		try (FileOutputStream outputStream = new FileOutputStream(desFile)) {
			byte[] decodeBase64 = Base64.decodeBase64(base64String);
			outputStream.write(decodeBase64);
			outputStream.close();
		} catch (IOException e1) {
			throw new DataFileException(ResponseCode.UPLOAD_FAIL);
		}
	}
	
	public static void mkdirCaseNotExist(File desFile) {
		if(!desFile.getParentFile().exists()) {
			desFile.getParentFile().mkdirs();
		} 
	}
}


