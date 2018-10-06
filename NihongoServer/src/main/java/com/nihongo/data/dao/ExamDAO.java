package com.nihongo.data.dao;

import java.util.List;

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

	public boolean update(String id, Boolean isActive, Boolean isFree, Boolean isTrial, Integer point, Integer completedMinutes);
	
	public SearchResult listExam(Integer level, Integer examType, int skip, int take);
	
	public SearchResult listFavoriteExam(List<String> examIds);
	
	public SearchResult search(SearchExamRequest request);
	
	public void encreaseLikeNumber(String examId);
	
	public void decreaseLikeNumber(String examId);
	
	public Exam getExam(String id, int clientQueryMode);
}
