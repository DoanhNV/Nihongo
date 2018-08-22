package com.nihongo.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.SettingDAO;
import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.service.data.SettingService;

/**
 * 
 * @author DoanhNV Aug 22, 2018 3:59:04 PM
 *
 */
@Service
public class SettingServiceImpl implements SettingService {
	
	@Autowired
	private SettingDAO settingDAO;
	
	@Override
	public boolean setExam(ExamSetting examSetting) {
		settingDAO.setExam(examSetting);
		return true;
	}
	
	@Override
	public List<ExamSetting> listExamSetting() {
		return settingDAO.listExamSetting();
	}

	@Override
	public ExamSetting getExamSetting(String id) {
		return null;
	}
}
