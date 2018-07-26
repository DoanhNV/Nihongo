package com.nihongo.data.converter;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.setting.LevelQuestionNumberSetting;

/**
 * 
 * @author DoanhNV Jul 19, 2018 5:56:17 PM
 *
 */
public class ExamSettingConverter {
	
	public DBObject toSaveObject(List<LevelQuestionNumberSetting> levelQuestionNumberSettings) {
		BasicDBObject saveObject = new BasicDBObject();
		return saveObject;
	}
}
