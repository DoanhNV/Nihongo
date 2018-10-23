package com.nihongo.data.dao;

import java.util.List;

import com.mongodb.DB;

/**
 * 
 * @author DoanhNV Sep 27, 2018 5:52:10 PM
 *
 */
public interface ExamFavoriteDAO {
	
	public static final DB USER_CONNECTION_DB = ExamLikeDAO.USER_CONNECTION_DB;
	
	public boolean isFavorited(String userId, String examId);

	public void addExamToFavoriteList(String userId, String examId);
	
	public void removeExamFromFavoriteList(String userId, String examId);
	
	public List<String> listFavoriteExam(String userId, int skip, int take);
}
