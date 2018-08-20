package com.nihongo.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.Question;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.service.data.MCQQuestionService;

@Service
public class MCQQuestionServiceImpl implements MCQQuestionService {
	
	@Autowired
	private MCQQuestionDAO mCQQuestionDAO;
	
	@Override
	public String insert(AbstractEntity entity) {
		return mCQQuestionDAO.insert(entity);
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
	public String delete(String id) {
		return null;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		SearchData searchData = mCQQuestionDAO.search(request);
		return searchData;
	}

	@Override
	public List<AbstractEntity> listAll() {
		return null;
	}

	@Override
	public SearchData listByIds(List<String> questionIds) {
		return mCQQuestionDAO.listByIds(questionIds);
	}
}
