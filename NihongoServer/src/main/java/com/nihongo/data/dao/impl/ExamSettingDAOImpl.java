package com.nihongo.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.nihongo.data.dao.ExamSettingDAO;
import com.nihongo.data.entity.setting.LevelQuestionNumberSetting;
import com.nihongo.support.constant.mongo.MongoConfigInfo.SETTING_DB;

/**
 * 
 * @author DoanhNV Jul 19, 2018 5:37:18 PM
 *
 */
@Repository
public class ExamSettingDAOImpl implements ExamSettingDAO {
	
	private static DBCollection examSettingCollection = null;
	
	static {
		examSettingCollection = EXAM_DATABASE.getCollection(SETTING_DB.EXAM_SETTING_COLLECTION);
	}
	
	@Override
	public boolean saveQuestionNumber(List<LevelQuestionNumberSetting> levelQuestionNumberSettings) {
		
		return false;
	}

	@Override
	public List<LevelQuestionNumberSetting> getQuestionNumber() {
		return null;
	}
}
