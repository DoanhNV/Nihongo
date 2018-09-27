package com.nihongo.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.ExamLikeDAO;
import com.nihongo.service.data.ExamLikeService;

/***
 * 
 * @author DoanhNV Sep 27, 2018 4:40:50 PM
 *
 */
@Service
public class ExamLikeServiceImpl implements ExamLikeService {

	@Autowired
	private ExamLikeDAO examLikeDAO;
	
	@Override
	public boolean likeExam(String userId, String examId) {
		return examLikeDAO.addExamToLikeList(userId, examId);
	}

	@Override
	public boolean unlikeExam(String userId, String examId) {
		return examLikeDAO.removeExamFromLikeList(userId, examId);
	}
}
