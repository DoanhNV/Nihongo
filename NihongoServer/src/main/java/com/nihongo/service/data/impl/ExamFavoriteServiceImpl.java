package com.nihongo.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.ExamFavoriteDAO;
import com.nihongo.service.data.ExamFavoriteService;

/**
 * 
 * @author DoanhNV Sep 27, 2018 5:51:24 PM
 *
 */
@Service
public class ExamFavoriteServiceImpl implements ExamFavoriteService {
	
	@Autowired
	private ExamFavoriteDAO examFavoriteDAO; 

	@Override
	public void favoriteExam(String userId, String examId) {
		examFavoriteDAO.addExamToFavoriteList(userId, examId);
	}

	@Override
	public void unfavoriteExam(String userId, String examId) {
		examFavoriteDAO.removeExamFromFavoriteList(userId, examId);
	}
}
