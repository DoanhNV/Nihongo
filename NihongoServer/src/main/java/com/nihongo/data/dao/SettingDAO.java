package com.nihongo.data.dao;

import java.util.List;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Aug 22, 2018 3:27:44 PM
 *
 */
public interface SettingDAO {
	
	public static DB examSettingDB  = MongoDBConnection.getDatabase(MongoConfigInfo.SETTING_DB);

	public boolean setExam(ExamSetting examSetting);
	
	public ExamSetting getExamSetting(String id);
	
	public ExamSetting getExamSetting(int level);
	
	public List<ExamSetting> listExamSetting();
}
