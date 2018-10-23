package com.nihongo.data.dao;

import java.util.List;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Sep 27, 2018 4:11:01 PM
 *
 */
public interface ExamLikeDAO {
	
	public static final DB USER_CONNECTION_DB = MongoDBConnection.getDatabase(MongoConfigInfo.USER_CONNECTION_DB);
	
	public boolean isLiked(String userId, String examId);
	
	public boolean addExamToLikeList(String userId, String examId);
	
	public boolean removeExamFromLikeList(String userId, String examId);
	
	public List<String> listLikeExam(String userId);
}
