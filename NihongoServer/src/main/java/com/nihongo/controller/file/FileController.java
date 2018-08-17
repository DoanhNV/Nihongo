package com.nihongo.controller.file;

import static com.nihongo.support.util.EntityUtil.transferSingleObjectTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.entity.file.DataFile;
import com.nihongo.dto.httpdto.request.file.LoadFileBase64Request;
import com.nihongo.dto.httpdto.request.file.UploadStreamRequest;
import com.nihongo.dto.httpdto.response.file.LoadBase64Response;
import com.nihongo.dto.httpdto.response.file.UploadStreamResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.FileService;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 8, 2018 12:27:47 PM
 */
@RestController
@RequestMapping(value = API.FILE.ROOT)
@CrossOrigin
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping(value = API.FILE.UPLOAD_BASE64)
	@ResponseBody
	public UploadStreamResponse upload(@RequestBody UploadStreamRequest request) {
		UploadStreamResponse response = new UploadStreamResponse();
		try {
			DataFile file = new DataFile();
			transferSingleObjectTo(request, file);
			String filePath = fileService.upload(file);
			response.setResponseInfo(ResponseCode.SUCCESS, filePath);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = API.FILE.LOAD_BASE64)
	@ResponseBody
	public LoadBase64Response loadFile(@RequestBody LoadFileBase64Request request) {
		LoadBase64Response response = new LoadBase64Response();
		try {
			String base64Str = fileService.loadFile(request.getFilePath());
			response.setResponseData(ResponseCode.SUCCESS, base64Str);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}

}
