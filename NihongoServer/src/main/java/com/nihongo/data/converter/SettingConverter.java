package com.nihongo.data.converter;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.data.entity.setting.TopicNumber;
import com.nihongo.support.constant.mongo.MongoDBKey.SETTING;

/**
 * 
 * @author DoanhNV Aug 22, 2018 3:40:01 PM
 *
 */
public class SettingConverter {

	/**
	 * Exam setting
	 */
	public static DBObject prepareSettingExamObject(ExamSetting examSetting) {
		BasicDBObject examSettingObject = new BasicDBObject();
		String id = examSetting.getId();
		int level = examSetting.getLevel();
		List<TopicNumber> topicConfigs = examSetting.getTopicConfigs();
		BasicDBList listTopicConfig = new BasicDBList();
		for (TopicNumber topicNumber : topicConfigs) {
			BasicDBObject topicNumberObject = new BasicDBObject();
			topicNumberObject.append(SETTING.TOPIC, topicNumber.getTopic());
			topicNumberObject.append(SETTING.NUMBER, topicNumber.getNumber());
			listTopicConfig.add(topicNumberObject);
		}

		examSettingObject.append(SETTING.ID, id);
		examSettingObject.append(SETTING.LEVEL, level);
		examSettingObject.append(SETTING.TOPIC_CONFIGS, listTopicConfig);
		return examSettingObject;
	}
	
	public static DBObject prepareGetExamSettingObject(String id) {
		BasicDBObject examSettingObject = new BasicDBObject();
		examSettingObject.append(SETTING.ID, id);
		return examSettingObject;
	}
	
	public static ExamSetting convertToExam(DBObject examSettingObject) {
		String id = examSettingObject.get(SETTING.ID).toString();
		Integer level = (Integer) examSettingObject.get(SETTING.LEVEL);
		BasicDBList listTopicConfig = (BasicDBList) examSettingObject.get(SETTING.TOPIC_CONFIGS);
		List<TopicNumber> topicConfigs = new ArrayList<>();
		for (Object item : listTopicConfig) {
			BasicDBObject topicNumberObject = (BasicDBObject) item;
			Integer topic = (Integer) topicNumberObject.get(SETTING.TOPIC);
			Integer number = (Integer) topicNumberObject.get(SETTING.NUMBER);
			TopicNumber topicNumber = new TopicNumber(topic, number);
			topicConfigs.add(topicNumber);
		}
		ExamSetting examSetting = new ExamSetting(id, level, topicConfigs);
		return examSetting;
	}
}
