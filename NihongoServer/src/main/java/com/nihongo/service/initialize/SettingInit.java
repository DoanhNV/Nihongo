package com.nihongo.service.initialize;

import com.nihongo.data.dao.SettingDAO;
import com.nihongo.data.dao.impl.SettingDAOImpl;
import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.service.manager.Exammanager;

/**
 * 
 * @author DoanhNV Aug 23, 2018 4:13:13 PM
 *
 */
public class SettingInit {

	private SettingDAO settingDAO = new SettingDAOImpl();

	public void init() {
		initExamSettingNumber();
	}

	public void initExamSettingNumber() {
		if (settingDAO.listExamSetting() == null || settingDAO.listExamSetting().size() == 0) {
			for (ExamSetting examSetting : Exammanager.listAllSetting()) {
				settingDAO.setExam(examSetting);
			}
		}
	}
}
