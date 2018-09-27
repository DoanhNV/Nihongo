package com.nihongo.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.nihongo.data.converter.ExamFavoriteConverter;
import com.nihongo.data.dao.ExamFavoriteDAO;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Sep 27, 2018 5:52:20 PM
 *
 */
@Repository
public class ExamFavoriteDAOImpl implements ExamFavoriteDAO {
	
	private static final DBCollection examFavoriteCollection = USER_CONNECTION_DB.getCollection(MongoConfigInfo.USER_CONNECTION.EXAM_FAVORITE_COLLECTION);
	
	@Override
	public void addExamToFavoriteList(String userId, String examId) {
		BasicDBObject query = ExamFavoriteConverter.prepareObjectId(userId);
		BasicDBObject addFavoriteExamObject = ExamFavoriteConverter.prepareAddFavoriteExamObject(examId);
		examFavoriteCollection.update(query, addFavoriteExamObject);
	}

	@Override
	public void removeExamFromFavoriteList(String userId, String examId) {
		BasicDBObject query = ExamFavoriteConverter.prepareObjectId(userId);
		BasicDBObject removeFavoriteExamObject = ExamFavoriteConverter.prepareRemoveFavoriteExamObject(examId);
		examFavoriteCollection.update(query, removeFavoriteExamObject);
	}
}
