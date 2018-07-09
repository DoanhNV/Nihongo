package com.nihongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.question.Question;
import com.nihongo.service.MCQQuestionService;

@Service
public class MCQQuestionServiceImpl implements MCQQuestionService {
	
	@Autowired
	private MCQQuestionDAO mCQQuestionDAO;
	
	@Override
	public boolean insert(AbstractEntity entity) {
		mCQQuestionDAO.insert(entity);
		return true;
	}

	@Override
	public boolean update(AbstractEntity entity) {
		return true;
	}

	@Override
	public Question getById(String id) {
		return null;
	}

	@Override
	public List<Question> listAll() {
		return mCQQuestionDAO.listAll();
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

}
