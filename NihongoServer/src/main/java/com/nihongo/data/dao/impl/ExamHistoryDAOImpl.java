package com.nihongo.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBList;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nihongo.data.converter.ExamHistoryConverter;
import com.nihongo.data.dao.ExamHistoryDAO;
import com.nihongo.support.constant.mongo.MongoConfigInfo;
import com.nihongo.support.constant.mongo.MongoDBKey;

@Repository
public class ExamHistoryDAOImpl implements ExamHistoryDAO {

	private static final DBCollection examHistoryCollection = USER_CONNECTION_DB.getCollection(MongoConfigInfo.USER_CONNECTION.EXAM_HISTORY);
	
	@Override
	public void updateHistory(String userId, List<String> examIds) {
		DBObject query = ExamHistoryConverter.prepareObjectId(userId);
		DBObject updateObject = ExamHistoryConverter.prepareUpdateObject(userId, examIds);
		examHistoryCollection.update(query, updateObject, true, false);
	}

	@Override
	public List<String> getHistoryExams(String userId) {
		List<String> examIds = new ArrayList<>();
		DBObject query = ExamHistoryConverter.prepareObjectId(userId);
		try (DBCursor cursor = examHistoryCollection.find(query)) {
			if (cursor.hasNext()) {
				DBObject examHistoryObject = cursor.next();
				BasicDBList listExamId = (BasicDBList) examHistoryObject.get(MongoDBKey.EXAM_HISTORY.EXAMS);
				
				for (Object id : listExamId) {
					String examId = (String) id;
					examIds.add(examId);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return examIds;
	}
}
