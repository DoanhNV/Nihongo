package com.nihongo.data.dao;

import java.util.List;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:04:30 AM
 */
public interface DocumentDAO extends IDAO {
	
	public List<String> getRandomQuestions(int topic, int level, int size);
	
	public void removeQuestion(String documentId, String questionId);
	
	public List<String> listQuestionByExamId(String examId);
}
