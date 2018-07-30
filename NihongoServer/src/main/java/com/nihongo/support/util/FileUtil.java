package com.nihongo.support.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.Base64Utils;

import com.nihongo.exception.DataFileException;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:38:32 PM
 */
public class FileUtil {
	
	public static void writeBase64ToFile(File desFile, String base64String) {
		try (FileOutputStream outputStream = new FileOutputStream(desFile)) {
			byte[] decodeBase64 = Base64.decodeBase64(base64String);
			outputStream.write(decodeBase64);
			outputStream.close();
		} catch (IOException e1) {
			throw new DataFileException(ResponseCode.UPLOAD_FAIL);
		}
	}
	
	public static String convertToBase64Str(String filePath) {
		String base64Str = Constant.FILE.BASE64_PREFIX;
		try {
			byte[] fileBytes = Files.readAllBytes(new File(filePath).toPath());
			byte[] code = Base64Utils.encode(fileBytes);
			base64Str += new String(code, Constant.ENCODING.UTF_8);
			return base64Str;
		} catch (IOException e) {
			throw new DataFileException(ResponseCode.FILE_NOT_EXIST);
		}
	}
	
	public static void mkdirCaseNotExist(File desFile) {
		if(!desFile.getParentFile().exists()) {
			desFile.getParentFile().mkdirs();
		} 
	}
}


