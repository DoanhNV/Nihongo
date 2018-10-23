package com.nihongo.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.ExamLikeDAO;
import com.nihongo.dto.httpdto.AbstractDTO;
import com.nihongo.dto.httpdto.entity.DetailEndUserExam;
import com.nihongo.dto.httpdto.entity.EndUserBasicExam;
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
	public boolean doLikeExamAction(String userId, String examId) {
		boolean isLiked = examLikeDAO.isLiked(userId, examId);
		
		if (isLiked) {
			examLikeDAO.removeExamFromLikeList(userId, examId);
		} else {
			examLikeDAO.addExamToLikeList(userId, examId);
		}
		return isLiked;
	}

	@Override
	public void processResponseLikeStatus(String userId, List<AbstractDTO> endUserExams) {
		final List<String> likeExamIds = examLikeDAO.listLikeExam(userId);
		
		for (AbstractDTO endUserExam : endUserExams) {
			EndUserBasicExam exam = (EndUserBasicExam) endUserExam;
			if(likeExamIds.contains(exam.getId())) {
				exam.setLiked(true);
			}
		}
	}

	@Override
	public void processLikeStatus(String userId, DetailEndUserExam exam) {
		boolean isLiked = examLikeDAO.isLiked(userId, exam.getId());
		if(isLiked) {
			exam.setLiked(true);
		}
	}
}
