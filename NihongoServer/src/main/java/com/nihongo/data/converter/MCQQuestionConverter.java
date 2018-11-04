package com.nihongo.data.converter;

import static com.nihongo.support.constant.Constant.QUERY_PROPERTIES.DEFAULT_SORT_FIELD;
import static com.nihongo.support.constant.Constant.QUERY_PROPERTIES.DEFAULT_SORT_VALUE;
import static com.nihongo.support.constant.Constant.QUERY_PROPERTIES.QUERY_ALL;
import static com.nihongo.support.constant.Constant.STRING_PROPERTIES.EMPTY;
import static com.nihongo.support.constant.mongo.MongoDBKey.CONTENT;
import static com.nihongo.support.constant.mongo.MongoDBKey.DOCUMENT;
import static com.nihongo.support.constant.mongo.MongoDBKey.ID;
import static com.nihongo.support.constant.mongo.MongoDBKey.LEVEL;
import static com.nihongo.support.constant.mongo.MongoDBKey.SUB_TITLE;
import static com.nihongo.support.constant.mongo.MongoDBKey.TOPIC;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.ANSWERS;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.IS_CORRECT;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.TITLE;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.Sort;
import com.nihongo.data.entity.question.Answer;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.dto.httpdto.request.MCQQuestionSearchRequest;
import com.nihongo.support.RequestValidator;
import com.nihongo.support.constant.mongo.MongoOperator;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:10:21 AM
 */
public class MCQQuestionConverter {
	
	/*
	 * INSERT
	 */
	public static DBObject toInsertDBObject(MCQQuestion question) {
		BasicDBObject desObject = new BasicDBObject();
		desObject.append(TITLE, question.getTitle());
		String document = question.getDocument() == null ? EMPTY : question.getDocument();
		desObject.append(DOCUMENT, document);
		desObject.append(TOPIC, question.getTopic());
		desObject.append(LEVEL, question.getLevel());
		desObject.append(SUB_TITLE, question.getTitleSub());
		List<Answer> answers = question.getAnswers();
		BasicDBList answerList = new BasicDBList();
		if(answers != null) {
			for (Answer answer : answers) {
				BasicDBObject answerObject = new BasicDBObject();
				answerObject.append(CONTENT, answer.getContent());
				answerObject.append(IS_CORRECT, answer.isIsCorrect());
				answerList.add(answerObject);
			}
		}
		desObject.append(ANSWERS, answerList);
		return desObject;
	}
	
	/*
	 * Update 
	 */
	public static DBObject toUpdateDBObject(MCQQuestion question) {
		BasicDBObject questionObject = new BasicDBObject();
		questionObject.append(TITLE, question.getTitle());
		String document = question.getDocument() == null ? EMPTY : question.getDocument();
		questionObject.append(DOCUMENT, document);
		questionObject.append(TOPIC, question.getTopic());
		questionObject.append(LEVEL, question.getLevel());
		questionObject.append(SUB_TITLE, question.getTitleSub());
		List<Answer> answers = question.getAnswers();
		BasicDBList answerList = new BasicDBList();
		if(answers != null) {
			for (Answer answer : answers) {
				BasicDBObject answerObject = new BasicDBObject();
				answerObject.append(CONTENT, answer.getContent());
				answerObject.append(IS_CORRECT, answer.isIsCorrect());
				answerList.add(answerObject);
			}
		}
		questionObject.append(ANSWERS, answerList);
		BasicDBObject updateObject = new BasicDBObject(MongoOperator.$SET, questionObject);
		return updateObject;
	}

	public static MCQQuestion toMCQQuestion(DBObject dbObject) {
		MCQQuestion question = new MCQQuestion();
		String id = dbObject.get(ID).toString();
		question.setId(id);
		String title = (String) dbObject.get(TITLE);
		question.setTitle(title);
		int topic = (Integer) dbObject.get(TOPIC);
		question.setTopic(topic);
		int level = (Integer) dbObject.get(LEVEL);
		question.setLevel(level);
		BasicDBList answerList = (BasicDBList) dbObject.get(ANSWERS);
		List<Answer> answers = new ArrayList<>();
		for (Object answerObj : answerList) {
			BasicDBObject bAnswerObj = (BasicDBObject) answerObj;
			boolean isCorrect  = bAnswerObj.getBoolean(IS_CORRECT, false);
			String content = bAnswerObj.getString(CONTENT);
			Answer answer = new Answer(content, isCorrect);
			answers.add(answer);
		}
		question.setAnswers(answers);
		String document = (String) dbObject.get(DOCUMENT);
		question.setDocument(document);
		String titleSub = (String) dbObject.get(SUB_TITLE);
		question.setTitleSub(titleSub);
		return question;
	}
	
	/*
	 * SEARCH
	 */
	
	public static DBObject toSearchObject(AbstractSearchRequest request) {
		MCQQuestionSearchRequest searchRequest = (MCQQuestionSearchRequest) request;
		BasicDBObject searchObject = new BasicDBObject();
		if(searchRequest.getTopic() != QUERY_ALL) {
			searchObject.append(TOPIC, searchRequest.getTopic());
		}
		if(searchRequest.getLevel() != QUERY_ALL) {
			searchObject.append(LEVEL, searchRequest.getLevel());
		}
		return searchObject;
	}
	
	public static DBObject toSortOjbect(Sort sort) {
		BasicDBObject sortObject = new BasicDBObject(DEFAULT_SORT_FIELD, DEFAULT_SORT_VALUE);
		if(RequestValidator.isValidSortRequest(sort)) {
			sortObject = new BasicDBObject(sort.getFieldName(), sort.getOrder());
		}
		return sortObject;
	}
	
	/*
	 * LIST BY IDS
	 */
	
	public static DBObject toListByIdsObject(List<String> questionIds) {
		BasicDBList questionIdList = new BasicDBList();
		BasicDBObject inOjbect = new BasicDBObject(MongoOperator.$IN, questionIdList);
		BasicDBObject queryObject = new BasicDBObject(ID, inOjbect);
		for (String questionId : questionIds) {
			questionIdList.add(new ObjectId(questionId));
		}
		return queryObject;
	}
	
	
	public static BasicDBObject prepareObjectId(String id) {
		ObjectId objectId = new ObjectId(id);
		return new BasicDBObject(ID, objectId);
	}
	
	public static BasicDBList prepareListObjectId (List<String> ids) {
		BasicDBList questionIds = new BasicDBList();
		for (String id : ids) {
			questionIds.add(new ObjectId(id));
		}
		return questionIds;
	}
	
	public static BasicDBObject prepareDeleteByIds (List<String> ids) {
		BasicDBList listObjectIds = prepareListObjectId(ids);
		BasicDBObject inObject = new BasicDBObject(MongoOperator.$IN, listObjectIds);
		return new BasicDBObject(ID, inObject);
	}
}
