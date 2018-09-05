package com.nihongo.data.dao.impl;

import static com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB.DOCUMENT_COLLECTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nihongo.data.converter.DocumentConverter;
import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.dto.httpdto.request.DocumentSearchRequest;
import com.nihongo.support.constant.mongo.MongoDBKey;
import com.nihongo.support.constant.mongo.MongoOperator;
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
		if (documentObject != null) {
			document = DocumentConverter.toDocument(documentObject);
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
		SearchData searchData = new SearchData();
		int total = 0;
		List<AbstractEntity> documents = new ArrayList<>();
		DocumentSearchRequest searchRequest = (DocumentSearchRequest) request;
		BasicDBObject searchobject = DocumentConverter.prepareSearchobject(searchRequest);
		BasicDBObject sortObject = DocumentConverter.toSortObject(searchRequest.getSort());

		DBCursor cursor = docCollection.find(searchobject);
		total = cursor.size();
		cursor = cursor.sort(sortObject);
		cursor = cursor.skip(searchRequest.getSkip()).limit(searchRequest.getTake());
		while (cursor.hasNext()) {
			DBObject documentObject = cursor.next();
			Document document = DocumentConverter.toDocument(documentObject);
			documents.add(document);
		}
		searchData.setTotal(total);
		searchData.setDatas(documents);
		return searchData;
	}

	@Override
	public  List<String> getRandomQuestions(int topic, int level, int size) {
		List<String> mcqQuestionIds = new ArrayList<>();
		BasicDBObject matchObject = new BasicDBObject(MongoDBKey.LEVEL, level).append(MongoDBKey.TOPIC, topic);
		BasicDBObject conditionQuery = new BasicDBObject(MongoOperator.$MATCH, matchObject);
		BasicDBObject randomSizeQuery = new BasicDBObject(MongoOperator.$SAMPLE, new BasicDBObject(MongoOperator.SIZE, size));
		BasicDBObject projecttionQuery = new BasicDBObject(MongoOperator.$PROJECT, new BasicDBObject(MongoDBKey.ID, MongoOperator.INCLUDE_FIELD));
			
		@SuppressWarnings("deprecation")
		Iterable<DBObject> results = docCollection.aggregate(
				Arrays.asList(
						conditionQuery,
						randomSizeQuery,
						projecttionQuery
				)
		).results();
		
		for (DBObject question : results) {
			String questionId = question.get(MongoDBKey.MCQQuestionKey.ID).toString();
			mcqQuestionIds.add(questionId);
		}
		return mcqQuestionIds;
	}
}
