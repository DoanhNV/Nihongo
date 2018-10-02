package com.nihongo.data.converter;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.support.constant.mongo.MongoDBKey;
import com.nihongo.support.constant.mongo.MongoOperator;

/**
 * 
 * @author DoanhNV Sep 27, 2018 4:23:24 PM
 *
 */
public class ExamLikeConverter {
	
	public static DBObject prepareAddExamToLikeList(String examId) {
		BasicDBObject newExam = new BasicDBObject(MongoDBKey.EXAM_LIKE.EXAMS, examId);
		return new BasicDBObject(MongoOperator.ADD_TO_SET, newExam);
	}
	
	public static DBObject prepareRemoveExamFromLikeList(String examId) {
		BasicDBObject newExam = new BasicDBObject(MongoDBKey.EXAM_LIKE.EXAMS, examId);
		return new BasicDBObject(MongoOperator.PULL, newExam);
	}
	
	public static DBObject prepareIsLikedExamQuery(String userId, String examId) {
		ObjectId objectId = new ObjectId(userId);
		BasicDBObject query = new BasicDBObject(MongoDBKey.EXAM_LIKE.ID,objectId);
		BasicDBObject  elementMatchObject = new BasicDBObject(MongoOperator.ELEMENT_MATCH, examId);
		return query.append(MongoDBKey.EXAM_LIKE.EXAMS, elementMatchObject);
	}
}
