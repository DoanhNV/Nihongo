package com.nihongo.data.dao.impl;

import static com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB.DOCUMENT_COLLECTION;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.nihongo.data.converter.DocumentConverter;
import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.support.constant.mongo.MongoDBKey.DocumentKey;


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
	public String insert(AbstractEntity entity) {
		Document document = (Document) entity;
		DBObject insertDBObject = DocumentConverter.toInsertDBObject(document);
		docCollection.insert(insertDBObject);
		return insertDBObject.get(DocumentKey.ID).toString();
	}

	@Override
	public boolean update(AbstractEntity entity) {
		Document document = (Document) entity;
		List<BasicDBObject> prepareUpdateObjects = DocumentConverter.prepareUpdateObject(document);
		docCollection.update(prepareUpdateObjects.get(0), prepareUpdateObjects.get(1));
		return true;
	}

	@Override
	public Document getById(String id) {
		Document document = new Document();
		DBObject queryObject = DocumentConverter.prepareGetDBObject(id);
		DBObject documentObject = docCollection.findOne(queryObject);
		if(documentObject != null) {
			document = DocumentConverter.toGetDocument(documentObject);
		}
		return document;
	}

	@Override
	public List<AbstractEntity> listAll() {
		return null;
	}

	@Override
	public String delete(String id) {
		return null;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		return null;
	}
}
