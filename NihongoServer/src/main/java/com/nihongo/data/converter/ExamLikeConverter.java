package com.nihongo.data.converter;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.support.constant.mongo.MongoOperator;
import com.nihongo.support.constant.mongo.MongoDBKey.EXAM_LIKE;

/**
 * 
 * @author DoanhNV Sep 27, 2018 4:23:24 PM
 *
 */
public class ExamLikeConverter {

	public static DBObject prepareAddExamToLikeList(String examId) {
		BasicDBObject newExam = new BasicDBObject(EXAM_LIKE.EXAMS, examId);
		return new BasicDBObject(MongoOperator.ADD_TO_SET, newExam);
	}

	public static DBObject prepareRemoveExamFromLikeList(String examId) {
		BasicDBObject newExam = new BasicDBObject(EXAM_LIKE.EXAMS, examId);
		return new BasicDBObject(MongoOperator.PULL, newExam);
	}

	public static DBObject prepareIsLikedExamQuery(String userId, String examId) {
		ObjectId objectId = new ObjectId(userId);
		BasicDBObject query = new BasicDBObject(EXAM_LIKE.ID, objectId);
		return query.append(EXAM_LIKE.EXAMS, examId);
	}

	public static DBObject prepareObjectId(String userId) {
		ObjectId objectId = new ObjectId(userId);
		return new BasicDBObject(EXAM_LIKE.ID, objectId);
	}

	public static List<String> convertToExamLikeIds(DBObject examLikeObject) {
		List<String> examLikeIds = new ArrayList<>();
		BasicDBList listExamId = (BasicDBList) examLikeObject.get(EXAM_LIKE.EXAMS);
		
		if (listExamId != null) {
			for (Object id : listExamId) {
				String examId = (String) id;
				examLikeIds.add(examId);
			}
		}
		return examLikeIds;
	}
}
