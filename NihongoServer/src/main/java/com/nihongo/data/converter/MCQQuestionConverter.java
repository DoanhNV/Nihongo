package com.nihongo.data.converter;

import static com.nihongo.support.constant.mongo.MongoDBKey.LEVEL;
import static com.nihongo.support.constant.mongo.MongoDBKey.TOPIC;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.ANSWERS;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.CONTENT;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.IS_CORRECT;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.TITLE;

import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.question.Answer;
import com.nihongo.data.entity.question.MCQQuestion;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:10:21 AM
 */
public class MCQQuestionConverter {

	public static DBObject toInsertDBObject(MCQQuestion question) {
		BasicDBObject desObject = new BasicDBObject();
		desObject.append(TITLE, question.getTitle());
		List<Answer> answers = question.getAnswers();
		BasicDBList answerList = new BasicDBList();
		for (Answer answer : answers) {
			BasicDBObject answerObject = new BasicDBObject();
			answerObject.append(CONTENT, answer.getContent());
			answerObject.append(IS_CORRECT, answer.isIsCorrect());
			answerList.add(answerObject);
		}
		desObject.append(ANSWERS, answerList);
		desObject.append(TOPIC, question.getTopic());
		desObject.append(LEVEL, question.getLevel());
		return desObject;
	}
}
