package com.nihongo.data.converter;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.Sort;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.DocumentSearchRequest;
import com.nihongo.support.RequestValidator;
import com.nihongo.support.constant.mongo.MongoOperator;

import static com.nihongo.support.constant.mongo.MongoDBKey.DocumentKey.*;
import static com.nihongo.support.constant.Constant.QUERY_PROPERTIES.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:10:55 AM
 */
public class DocumentConverter {
		
	public static DBObject toInsertDBObject(Document document) {
		BasicDBObject desObject = new BasicDBObject();
		desObject.append(CONTENT, document.getContent());
		desObject.append(TOPIC, document.getTopic());
		desObject.append(LEVEL, document.getLevel());
		List<String> questionIds = document.getQuestionIds();
		BasicDBList questionIdList = new BasicDBList();
		if(questionIds != null) {
			for (String questionId : questionIds) {
				questionIdList.add(questionId);
			}
		}
		desObject.append(QUESTION_IDS, questionIdList);
		return desObject;
	}
	
	/*
	 * GET
	 */
	
	public static DBObject prepareGetDBObjectId(String id) {
		return new BasicDBObject(ID, new ObjectId(id));
	}
	
	public static Document toDocument(DBObject documentObject) {
		String documentId = documentObject.get(ID).toString();
		String content = (String) documentObject.get(CONTENT);
		Integer topic = (Integer) documentObject.get(TOPIC);
		Integer level = (Integer) documentObject.get(LEVEL);
		List<String> questionIds = new ArrayList<>();
		BasicDBList questionList =  (BasicDBList) documentObject.get(QUESTION_IDS);
		for (Object questionId : questionList) {
			questionIds.add((String) questionId);
		}
		Document document = new Document(documentId, content, topic, level, questionIds);
		return document;
	}
	
	/*
	 * UPDATE
	 */
	
	public static List<BasicDBObject> prepareUpdateObject(Document document) {
		List<BasicDBObject> dbobjectList = new ArrayList<>();
		ObjectId objectId = new ObjectId(document.getId());
		BasicDBObject queryObject = new BasicDBObject(ID, objectId);
		BasicDBObject setObject = new BasicDBObject();
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.append(TOPIC, document.getTopic());
		updateObject.append(LEVEL, document.getLevel());
		if(document.getContent() != null) {
			updateObject.append(CONTENT, document.getContent());
		}
		if(document.getQuestionIds() != null) {
			BasicDBList questionIds = new BasicDBList();
			for (String questionId : document.getQuestionIds()) {
				questionIds.add(questionId);
			}
			updateObject.append(QUESTION_IDS, questionIds);
		}
		setObject.append(MongoOperator.$SET, updateObject);
		dbobjectList.add(queryObject);
		dbobjectList.add(setObject);
		return dbobjectList;
	}
	
	
	/*
	 * SEARCH 
	 */
	
	public static BasicDBObject prepareSearchobject(DocumentSearchRequest request) {
		BasicDBObject searchObject = new BasicDBObject();
		
		if(request.getTopic() != QUERY_ALL) {
			searchObject.append(TOPIC, request.getTopic());
		}
		if(request.getLevel() != QUERY_ALL) {
			searchObject.append(LEVEL, request.getLevel());
		}
		return searchObject;
	}
	
	
	public static BasicDBObject toSortObject(Sort sort) {
		BasicDBObject sortObject = new BasicDBObject(DEFAULT_SORT_FIELD, DEFAULT_SORT_VALUE);
		if(RequestValidator.isValidSortRequest(sort)) {
			sortObject = new BasicDBObject(sort.getFieldName(), sort.getOrder());
		}
		return sortObject;
	}
}
