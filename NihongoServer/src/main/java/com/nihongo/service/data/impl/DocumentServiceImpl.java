package com.nihongo.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.dao.ExamDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.DocumentService;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:52:13 AM
 */
@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentDAO documentDAO;
	@Autowired
	private ExamDAO examDAO;

	@Override
	public String insert(AbstractEntity entity) {
		return documentDAO.insert(entity);
	}

	@Override
	public boolean update(AbstractEntity entity) {
		return documentDAO.update(entity);
	}

	@Override
	public Document getById(String id) {
		Document document =  (Document) documentDAO.getById(id);
		return document;
	}

	@Override
	public List<AbstractEntity> listAll() {
		return null;
	}

	@Override
	public String delete(String id) {

		if (examDAO.isExistDocument(id)) {
			throw new AbstractNihongoException(ResponseCode.DOCUMENT_IS_IN_EXAM);
		}
		
		documentDAO.delete(id);
		return null;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		return documentDAO.search(request);
	}

	@Override
	public List<String> listQuestionByExamId(String examId) {
		return documentDAO.listQuestionByExamId(examId);
	}
}
