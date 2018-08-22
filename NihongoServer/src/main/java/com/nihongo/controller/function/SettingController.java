package com.nihongo.controller.function;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.dto.httpdto.request.ExamSettingRequest;
import com.nihongo.dto.httpdto.response.ExamSettingResponse;
import com.nihongo.dto.httpdto.response.ListExamSettingResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.SettingService;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.support.util.EntityUtil;

/**
 * 
 * @author DoanhNV Aug 21, 2018 4:55:03 PM
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = API.SETTING.ROOT)
public class SettingController {

	@Autowired
	private SettingService settingService;

	@PutMapping(value = API.SETTING.SET_EXAM_NUMBER)
	@ResponseBody
	public ExamSettingResponse settingExam(@RequestBody ExamSettingRequest request) {
		ExamSettingResponse response = new ExamSettingResponse(ResponseCode.SUCCESS);
		try {
			ExamSetting examSetting = new ExamSetting();
			EntityUtil.transferObjectTo(request, examSetting);
			settingService.setExam(examSetting);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}

	@GetMapping(value = API.SETTING.LIST_EXAM_SETTING)
	@ResponseBody
	public ListExamSettingResponse listExamSetting() {
		ListExamSettingResponse response = new ListExamSettingResponse();
		try {
			List<ExamSetting> examSettings = settingService.listExamSetting();
			response.setResponseData(ResponseCode.SUCCESS, examSettings);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
}
