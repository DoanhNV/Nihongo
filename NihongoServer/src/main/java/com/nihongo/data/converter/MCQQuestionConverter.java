package com.nihongo.data.converter;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.question.Answer;
import com.nihongo.data.entity.question.MCQQuestion;
import static com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey.*;

import java.util.List;

public class MCQQuestionConverter {
	
	public static DBObject toInsertDBObject(MCQQuestion question) {
		BasicDBObject  desObject = new BasicDBObject();
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
