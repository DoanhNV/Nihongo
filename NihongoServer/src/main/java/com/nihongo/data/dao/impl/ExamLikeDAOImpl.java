package com.nihongo.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
	
	private static DBCollection examLikecollection = USER_CONNECTION_DB.getCollection(MongoConfigInfo.USER_CONNECTION.EXAM_LIKE_COLLECTION);
	
	@Override
	public boolean addExamToLikeList(String userId, String examId) {
		ObjectId objectId = new ObjectId(userId);
		BasicDBObject query = new BasicDBObject(MongoDBKey.EXAM_LIKE.ID,objectId);
		DBObject prepateAddExamToLikeList = ExamLikeConverter.prepareAddExamToLikeList(examId);
		examLikecollection.update(query, prepateAddExamToLikeList, true, false);
		return true;
	}

	@Override
	public boolean removeExamFromLikeList(String userId, String examId) {
		ObjectId objectId = new ObjectId(userId);
		BasicDBObject query = new BasicDBObject(MongoDBKey.EXAM_LIKE.ID,objectId);
		DBObject prepateAddExamToLikeList = ExamLikeConverter.prepareRemoveExamFromLikeList(examId);
		examLikecollection.update(query, prepateAddExamToLikeList, true, false);
		return true;
	}

	@Override
	public boolean isLiked(String userId, String examId) {
		DBObject query = ExamLikeConverter.prepareIsLikedExamQuery(userId, examId);
		long recordNumber = examLikecollection.count(query);
		return recordNumber != 0;
	}

	@Override
	public List<String> listLikeExam(String userId) {
		List<String> likeExamIds = new ArrayList<>();
		DBObject query = ExamLikeConverter.prepareObjectId(userId);
		DBObject examLikeObject = examLikecollection.findOne(query);
		if (examLikeObject != null) {
			likeExamIds = ExamLikeConverter.convertToExamLikeIds(examLikeObject);
		}
		return likeExamIds;
	}
}
