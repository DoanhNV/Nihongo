package com.nihongo.data.dao;

import com.mongodb.DB;

/**
 * 
 * @author DoanhNV Sep 27, 2018 5:52:10 PM
 *
 */
public interface ExamFavoriteDAO {
	
	public static final DB USER_CONNECTION_DB = ExamLikeDAO.EXAM_DB;

	public void addExamToFavoriteList(String userId, String examId);
	
	public void removeExamFromFavoriteList(String userId, String examId);
}
