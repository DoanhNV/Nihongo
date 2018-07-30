package com.nihongo.service.impl;

import static com.nihongo.support.constant.Constant.FILE.DEFAULT_IMAGE_DIRECTORY;
import static com.nihongo.support.constant.Constant.FILE.DEFAULT_IMAGE_EXTENTION;
import static com.nihongo.support.constant.Constant.FILE.DEFAULT_VIDEO_DIRECTORY;
import static com.nihongo.support.constant.Constant.FILE.DEFAULT_VIDEO_EXTENTION;
import static com.nihongo.support.constant.Constant.FILE.IMAGE_TYPE;

import java.io.File;

import org.springframework.stereotype.Service;

import com.nihongo.data.entity.file.DataFile;
import com.nihongo.service.FileService;
import com.nihongo.support.util.FileUtil;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:15:18 PM
 */
@Service
public class FileServiceImpl implements FileService {

	@Override
	public String upload(DataFile file) {
		String defaultFileDir = file.getFileType() == IMAGE_TYPE ?  DEFAULT_IMAGE_DIRECTORY : DEFAULT_VIDEO_DIRECTORY;
		String defaultFileExtention = file.getFileType() == IMAGE_TYPE ?  DEFAULT_IMAGE_EXTENTION : DEFAULT_VIDEO_EXTENTION;
		String filePath = defaultFileDir +  file.getFileName() + defaultFileExtention;
		File desFile = new File(filePath);
		FileUtil.mkdirCaseNotExist(desFile);
		FileUtil.writeBase64ToFile(desFile, file.getBase64Stream());
		return filePath;
	}

}
