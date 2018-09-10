package com.nihongo.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nihongo.data.converter.SettingConverter;
import com.nihongo.data.dao.SettingDAO;
import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.support.constant.mongo.MongoDBKey;
import com.nihongo.support.constant.mongo.MongoConfigInfo.SETTING;

/**
 * 
 * @author DoanhNV Aug 22, 2018 3:28:13 PM
 *
 */
@Repository
public class SettingDAOImpl implements SettingDAO {
	
	private static DBCollection examSettingCollection = examSettingDB.getCollection(SETTING.EXAM_SETTING_COLLECTION);
	
	@Override
	public boolean setExam(ExamSetting examSetting) {
		DBObject examSettingObject = SettingConverter.prepareSettingExamObject(examSetting);
		examSettingCollection.save(examSettingObject);
		return true;
	}

	@Override
	public List<ExamSetting> listExamSetting() {
		List<ExamSetting> examSettings = new ArrayList<>(); 
		DBCursor cursor = examSettingCollection.find();
		while (cursor.hasNext()) {
			DBObject examSettingObject = cursor.next();
			ExamSetting examSetting = SettingConverter.convertToExam(examSettingObject);
			examSettings.add(examSetting);
		}
		return examSettings;
	}

	@Override
	public ExamSetting getExamSetting(String id) {
		return null;
	}

	@Override
	public ExamSetting getExamSetting(int level) {
		BasicDBObject levelQuery = new  BasicDBObject(MongoDBKey.SETTING.LEVEL, level);
		DBObject examSettingObject = examSettingCollection.findOne(levelQuery);
		if(examSettingObject != null) {
			return SettingConverter.convertToExam(examSettingObject);
		}
		return new ExamSetting();
	}
}
