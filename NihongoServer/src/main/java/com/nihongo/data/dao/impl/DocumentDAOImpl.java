package com.nihongo.data.dao.impl;

import static com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB.DOCUMENT_COLLECTION;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.nihongo.data.converter.DocumentConverter;
import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.Question;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;


/**
 * 
 * @author DoanhNV Jul 8, 2018 11:04:25 AM
 */
@Repository
public class DocumentDAOImpl implements DocumentDAO {
	private static DBCollection docCollection = null;
	
	static {
		docCollection = EXAM_DATABASE.getCollection(DOCUMENT_COLLECTION);
	}
	
	@Override
	public boolean insert(AbstractEntity entity) {
		Document document = (Document) entity;
		DBObject insertDBObject = DocumentConverter.toInsertDBObject(document);
		docCollection.insert(insertDBObject);
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
	public List<AbstractEntity> listAll() {
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		return null;
	}
}
