package com.nihongo.data.dao;

import java.util.List;
import java.util.Map;

import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.Question;

/**
 * 
 * @author DoanhNV Jul 7, 2018 9:38:44 PM
 */
public interface MCQQuestionDAO extends IDAO {
	
	public Map<Integer, List<Question>> getRandomExam(int level, List<Integer> topics);
	
	public SearchData listByIds(List<String> questionIds);
	
	public List<String> getRandomQuestions(int topic, int level, int size);
	
	public boolean removeQuestionByIds(List<String> questionIds);
}
