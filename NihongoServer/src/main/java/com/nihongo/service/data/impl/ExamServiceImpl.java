package com.nihongo.service.data.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.Question;
import com.nihongo.dto.httpdto.RandomExamDTO;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.service.data.ExamService;

/**
 * 
 * @author DoanhNV Jul 9, 2018 11:10:27 AM
 */
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private MCQQuestionDAO mcqQuestionDAO;

	@Override
	public String insert(AbstractEntity entity) {
		return null;
	}

	@Override
	public boolean update(AbstractEntity entity) {
		return false;
	}

	@Override
	public Question getById(String id) {
		return null;
	}

	@Override
	public List<AbstractEntity> listAll() {
		return null;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		return null;
	}

	@Override
	public String delete(String id) {
		return null;
	}

	@Override
	public List<RandomExamDTO> getRandomExam(int level, List<Integer> topics) {
		List<RandomExamDTO> exams = new ArrayList<>();
		Map<Integer, List<Question>> examMap = mcqQuestionDAO.getRandomExam(level, topics);
		for (Entry<Integer, List<Question>> entry : examMap.entrySet()) {
			RandomExamDTO randomExamDTO = new RandomExamDTO(entry.getKey(), entry.getValue());
			exams.add(randomExamDTO);
		}
		return exams;
	}
}