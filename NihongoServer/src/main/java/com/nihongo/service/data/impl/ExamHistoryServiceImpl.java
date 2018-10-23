package com.nihongo.service.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.ExamHistoryDAO;
import com.nihongo.service.data.ExamHistoryService;
import com.nihongo.support.constant.Constant;

@Service
public class ExamHistoryServiceImpl implements ExamHistoryService {

	@Autowired
	private ExamHistoryDAO exmaHistoryDAO;
	
	@Override
	public void addHistoryExam(String userId, String examId) {
		List<String> newHistoryExamIds = new ArrayList<>();
		List<String> historyExamIds = exmaHistoryDAO.getHistoryExams(userId);
		newHistoryExamIds.add(examId);
		
		for (String id : historyExamIds) {
			boolean isMaxHistoryExam = newHistoryExamIds.size() == Constant.MAX_HISTORY_EXAM_NUMBER;
			if (isMaxHistoryExam) {
				break;
			}
			
			boolean isNotNewHistoryExam = !id.equals(examId);
			if(isNotNewHistoryExam) {
				newHistoryExamIds.add(id);
			}
		}
		exmaHistoryDAO.updateHistory(userId, newHistoryExamIds);
	}
	
	
}
