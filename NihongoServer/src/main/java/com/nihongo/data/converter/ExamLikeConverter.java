package com.nihongo.data.converter;

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
		return new BasicDBObject(MongoOperator.PUSH, newExam);
	}
	
	public static DBObject prepareRemoveExamFromLikeList(String examId) {
		BasicDBObject newExam = new BasicDBObject(MongoDBKey.EXAM_LIKE.EXAMS, examId);
		return new BasicDBObject(MongoOperator.PULL, newExam);
	}
}
