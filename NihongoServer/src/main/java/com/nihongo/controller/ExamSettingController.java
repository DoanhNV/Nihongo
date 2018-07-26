package com.nihongo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.dto.httpdto.request.SaveLevelQuestionSettingRequest;
import com.nihongo.dto.httpdto.response.SaveLevelQuestionSettingResponse;
import com.nihongo.exception.AbstractNihongoException;

/**
 * 
 * @author DoanhNV Jul 19, 2018 5:27:17 PM
 *
 */
@RestController
@RequestMapping(value = "/setting/exam")
public class ExamSettingController {
	
	@RequestMapping(value = "/save")
	public SaveLevelQuestionSettingResponse save(@RequestBody SaveLevelQuestionSettingRequest request) {
		SaveLevelQuestionSettingResponse response = new SaveLevelQuestionSettingResponse();
		try {
			
		} catch (AbstractNihongoException e) {
			
		} catch (Exception e) {
			
		}
		return response;
	}
}
