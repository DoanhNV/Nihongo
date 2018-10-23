package com.nihongo.data.dao;

import java.util.List;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

public interface ExamHistoryDAO {
	
	public static final DB USER_CONNECTION_DB = MongoDBConnection.getDatabase(MongoConfigInfo.USER_CONNECTION_DB);
	
	public void updateHistory(String userId, List<String> examIds);
	
	public List<String> getHistoryExams(String userId);
}
