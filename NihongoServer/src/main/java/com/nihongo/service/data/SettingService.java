package com.nihongo.service.data;

import java.util.List;

import com.nihongo.data.entity.setting.ExamSetting;

/**
 * 
 * @author DoanhNV Aug 22, 2018 3:58:27 PM
 *
 */
public interface SettingService {
	
	public boolean setExam(ExamSetting examSetting);
	
	public List<ExamSetting> listExamSetting();
	
	public ExamSetting getExamSetting(String id);
}
