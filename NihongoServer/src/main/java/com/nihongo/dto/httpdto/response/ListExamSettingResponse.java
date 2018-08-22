package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.data.entity.setting.ExamSetting;

/**
 * 
 * @author DoanhNV Aug 22, 2018 4:35:00 PM
 *
 */
public class ListExamSettingResponse extends AbstractNihongoResponse {
	
	private List<ExamSetting> examSettings;

	public List<ExamSetting> getExamSettings() {
		return examSettings;
	}

	public void setExamSettings(List<ExamSetting> examSettings) {
		this.examSettings = examSettings;
	}
	
	public void setResponseData(float code, List<ExamSetting> examSettings) {
		this.code = code;
		this.examSettings = examSettings;
	}
} 
