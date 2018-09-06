package com.nihongo.data.dao;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.data.entity.other.transfer.SearchResult;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Jul 9, 2018 10:20:49 AM
 */
public interface ExamDAO {
	
	public static final DB EXAM_DATABASE = MongoDBConnection.getDatabase(MongoConfigInfo.EXAM_DB);
	
	public boolean insert(Exam exam);

	public SearchResult search(SearchExamRequest request);
	
	public Exam getExam(String id, int clientQueryMode);
	
	public boolean update(String id, Boolean isActive, Boolean isFree, Boolean isTrial, Integer point, Integer completedMinutes);
}
