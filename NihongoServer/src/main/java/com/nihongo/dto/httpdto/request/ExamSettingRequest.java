package com.nihongo.dto.httpdto.request;

import com.nihongo.data.entity.setting.ExamSetting;

/**
 * 
 * @author DoanhNV Aug 21, 2018 4:58:41 PM
 *
 */
public class ExamSettingRequest extends AbstractNihongoRequest {
	
	private int id;
	private ExamSetting examSetting;
	
	public ExamSettingRequest() {

	}

	public ExamSettingRequest(int id, ExamSetting examSetting) {
		this.id = id;
		this.examSetting = examSetting;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ExamSetting getExamSetting() {
		return examSetting;
	}

	public void setExamSetting(ExamSetting examSetting) {
		this.examSetting = examSetting;
	}
}
