package com.nihongo.controller.function;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.dto.httpdto.request.ExamSettingRequest;
import com.nihongo.dto.httpdto.response.ExamSettingResponse;

/**
 * 
 * @author DoanhNV Aug 21, 2018 4:55:03 PM
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "")
public class SettingController {
	
	@PutMapping()
	public ExamSettingResponse settingExam(@RequestBody ExamSettingRequest request) {
		ExamSettingResponse response = new ExamSettingResponse();
		return response;
	}
}
