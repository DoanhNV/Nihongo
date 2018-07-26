package com.nihongo.data.dao;

import java.util.List;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.data.entity.setting.LevelQuestionNumberSetting;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Jul 19, 2018 5:36:47 PM
 *
 */
public interface ExamSettingDAO {
	
	public static final DB EXAM_DATABASE = MongoDBConnection.getDatabase(MongoConfigInfo.SETTING_DB);
	
	public boolean saveQuestionNumber(List<LevelQuestionNumberSetting> levelQuestionNumberSettings);
	public List<LevelQuestionNumberSetting> getQuestionNumber(); 
}
