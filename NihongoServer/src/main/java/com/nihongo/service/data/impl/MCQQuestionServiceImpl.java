package com.nihongo.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.dao.ExamDAO;
import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.Question;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.MCQQuestionService;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Nov 1, 2018 - 10:29:03 PM
 *
 */
@Service
public class MCQQuestionServiceImpl implements MCQQuestionService {
	
	@Autowired
	private MCQQuestionDAO mCQQuestionDAO;
	@Autowired
	private ExamDAO examDAO;
	@Autowired
	private DocumentDAO documentDAO;
	
	@Override
	public String insert(AbstractEntity entity) {
		return mCQQuestionDAO.insert(entity);
	}
	
	@Override
	public String delete(String id) {
		if(examDAO.isExistsQuestion(id)) {
			throw new AbstractNihongoException(ResponseCode.QUESTION_IS_IN_EXAM);
		}
		return mCQQuestionDAO.delete(id);
	}

	@Override
	public boolean update(AbstractEntity entity) {
		return mCQQuestionDAO.update(entity);
	}
	
	@Override
	public boolean deleteDocumentQuestion(String documentId, String questionId) {
		mCQQuestionDAO.delete(questionId);
		documentDAO.removeQuestion(documentId, questionId);
		return true;
	}

	@Override
	public Question getById(String id) {
		Question question = (Question) mCQQuestionDAO.getById(id);
		return question;
	}
	
	@Override
	public List<AbstractEntity> listAll() {
		return null;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		SearchData searchData = mCQQuestionDAO.search(request);
		return searchData;
	}

	@Override
	public SearchData listByIds(List<String> questionIds) {
		return mCQQuestionDAO.listByIds(questionIds);
	}

	@Override
	public boolean deleteQuestionByIds(List<String> questionIds) {
		mCQQuestionDAO.removeQuestionByIds(questionIds);
		return true;
	}
}
