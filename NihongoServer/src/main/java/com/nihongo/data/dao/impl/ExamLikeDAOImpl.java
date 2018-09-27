package com.nihongo.data.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.nihongo.data.converter.ExamLikeConverter;
import com.nihongo.data.dao.ExamLikeDAO;
import com.nihongo.support.constant.mongo.MongoConfigInfo;
import com.nihongo.support.constant.mongo.MongoDBKey;

/**
 * 
 * @author DoanhNV Sep 27, 2018 4:11:25 PM
 *
 */
@Repository
public class ExamLikeDAOImpl implements ExamLikeDAO {
	
	private static DBCollection examLikecollection = EXAM_DB.getCollection(MongoConfigInfo.USER_CONNECTION.EXAM_LIKE_COLLECTION);
	
	@Override
	public boolean addExamToLikeList(String userId, String examId) {
		ObjectId objectId = new ObjectId(userId);
		BasicDBObject query = new BasicDBObject(MongoDBKey.EXAM_LIKE.ID,objectId);
		DBObject prepateAddExamToLikeList = ExamLikeConverter.prepareAddExamToLikeList(examId);
		examLikecollection.update(query, prepateAddExamToLikeList);
		return true;
	}

	@Override
	public boolean removeExamFromLikeList(String userId, String examId) {
		ObjectId objectId = new ObjectId(userId);
		BasicDBObject query = new BasicDBObject(MongoDBKey.EXAM_LIKE.ID,objectId);
		DBObject prepateAddExamToLikeList = ExamLikeConverter.prepareRemoveExamFromLikeList(examId);
		examLikecollection.update(query, prepateAddExamToLikeList);
		return true;
	}
}
