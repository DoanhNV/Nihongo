package com.nihongo.data.converter;

import static com.nihongo.support.constant.Constant.PROPERTIES.DEFAULT_SORT_FIELD;
import static com.nihongo.support.constant.Constant.PROPERTIES.DEFAULT_SORT_VALUE;
import static com.nihongo.support.constant.Constant.PROPERTIES.QUERY_ALL;
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

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.Sort;
import com.nihongo.data.entity.question.Answer;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.dto.httpdto.request.MCQQuestionSearchRequest;
import com.nihongo.support.RequestValidator;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:10:21 AM
 */
public class MCQQuestionConverter {

	public static DBObject toInsertDBObject(MCQQuestion question) {
		BasicDBObject desObject = new BasicDBObject();
		desObject.append(TITLE, question.getTitle());
		desObject.append(DOCUMENT, question.getDocument());
		desObject.append(TOPIC, question.getTopic());
		desObject.append(LEVEL, question.getLevel());
		desObject.append(SUB_TITLE, question.getTitleSub());
		List<Answer> answers = question.getAnswers();
		BasicDBList answerList = new BasicDBList();
		for (Answer answer : answers) {
			BasicDBObject answerObject = new BasicDBObject();
			answerObject.append(CONTENT, answer.getContent());
			answerObject.append(IS_CORRECT, answer.isIsCorrect());
			answerList.add(answerObject);
		}
		desObject.append(ANSWERS, answerList);
		return desObject;
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
}
