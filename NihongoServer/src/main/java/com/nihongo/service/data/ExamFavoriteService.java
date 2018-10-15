package com.nihongo.service.data;

import com.nihongo.dto.httpdto.entity.DetailEndUserExam;

/**
 * 
 * @author DoanhNV Sep 27, 2018 5:51:10 PM
 *
 */
public interface ExamFavoriteService {
	
	public void favoriteExam(String userId, String examId);
	
	public void processFavoriteStatus(String userId, DetailEndUserExam exam);
}
