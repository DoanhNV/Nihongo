package com.nihongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.service.DocumentService;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:52:13 AM
 */
@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentDAO documentDAO;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		return null;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
