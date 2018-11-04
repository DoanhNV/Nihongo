package com.nihongo.data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.nihongo.data.converter.ExamFavoriteConverter;
import com.nihongo.data.dao.ExamFavoriteDAO;
import com.nihongo.support.constant.mongo.MongoConfigInfo;
import com.nihongo.support.constant.mongo.MongoDBKey;

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
		BasicDBObject query = ExamFavoriteConverter.prepareIdObject(userId);
		BasicDBObject addFavoriteExamObject = ExamFavoriteConverter.prepareAddFavoriteExamObject(examId);
		examFavoriteCollection.update(query, addFavoriteExamObject, true, false);
	}

	@Override
	public void removeExamFromFavoriteList(String userId, String examId) {
		BasicDBObject query = ExamFavoriteConverter.prepareIdObject(userId);
		BasicDBObject removeFavoriteExamObject = ExamFavoriteConverter.prepareRemoveFavoriteExamObject(examId);
		examFavoriteCollection.update(query, removeFavoriteExamObject);
	}
	
	@Override
	public void removeExamFromFavoriteList(String examId) {
		BasicDBObject queryAll = new BasicDBObject();
		BasicDBObject removeFavoriteExamObject = ExamFavoriteConverter.prepareRemoveFavoriteExamObject(examId);
		examFavoriteCollection.update(queryAll, removeFavoriteExamObject, false, true);
	}

	@Override
	public List<String> listFavoriteExam(String userId, int skip, int take) {
		List<String> favoriteExamIds = new ArrayList<>();
		BasicDBObject query = ExamFavoriteConverter.prepareIdObject(userId);
		DBObject favoritesExamObject = examFavoriteCollection.findOne(query);
		
		if (favoritesExamObject != null) {
			BasicDBList listFavoriteExamId = (BasicDBList) favoritesExamObject.get(MongoDBKey.EXAM_FAVORITE.EXAMS);
			
			if (listFavoriteExamId == null) {
				return favoriteExamIds;
			}
			take = take > listFavoriteExamId.size() ? listFavoriteExamId.size() : take;
			
			List<Object> subListFavoriteExamId = listFavoriteExamId.subList(skip, take);
			for (Object examId : subListFavoriteExamId) {
				String favoriteExamId = (String) examId;
				favoriteExamIds.add(favoriteExamId);
			}
		}
		return favoriteExamIds;
	}

	@Override
	public boolean isFavorited(String userId, String examId) {
		BasicDBObject query = ExamFavoriteConverter.prepareIsFavoritedQuery(userId, examId);
		long recordNumber = examFavoriteCollection.count(query);
		return recordNumber != 0;
	}
}
