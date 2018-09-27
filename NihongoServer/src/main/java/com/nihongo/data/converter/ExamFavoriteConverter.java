package com.nihongo.data.converter;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.nihongo.support.constant.mongo.MongoDBKey;
import com.nihongo.support.constant.mongo.MongoOperator;

/**
 * 
 * @author DoanhNV Sep 27, 2018 6:01:03 PM
 *
 */
public class ExamFavoriteConverter {
	
	public static BasicDBObject prepareAddFavoriteExamObject(String examId) {
		BasicDBObject addFavoriteExamObject = new BasicDBObject(MongoDBKey.EXAM_FAVORITE.EXAMS, examId);
		return new BasicDBObject(MongoOperator.PUSH, addFavoriteExamObject);
	}
	
	public static BasicDBObject prepareRemoveFavoriteExamObject(String examId) {
		BasicDBObject removeFavoriteExamObject = new BasicDBObject(MongoDBKey.EXAM_FAVORITE.EXAMS, examId);
		return new BasicDBObject(MongoOperator.PULL, removeFavoriteExamObject);
	}
	
	public static BasicDBObject prepareIdObject(String userId) {
		return new BasicDBObject(MongoDBKey.EXAM_FAVORITE.ID, new ObjectId(userId));
	}
}
