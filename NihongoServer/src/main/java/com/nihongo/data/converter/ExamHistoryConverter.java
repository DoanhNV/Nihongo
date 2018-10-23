package com.nihongo.data.converter;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.support.constant.mongo.MongoDBKey;
import com.nihongo.support.constant.mongo.MongoOperator;

public class ExamHistoryConverter {
	
	public static DBObject prepareUpdateObject(String userId, List<String> examIds) {
		BasicDBList listExamId = new BasicDBList();
		
		for (String examId : examIds) {
			listExamId.add(examId);
		}
		BasicDBObject updateObject = new BasicDBObject(MongoDBKey.EXAM_HISTORY.EXAMS, listExamId);
		return new BasicDBObject(MongoOperator.$SET, updateObject);
	}
	
	public static DBObject prepareObjectId(String userId) {
		ObjectId id = new ObjectId(userId);
		return new BasicDBObject(MongoDBKey.EXAM_HISTORY.ID, id);
	}
}
