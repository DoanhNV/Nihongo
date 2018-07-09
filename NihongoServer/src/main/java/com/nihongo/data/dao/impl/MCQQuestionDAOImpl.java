package com.nihongo.data.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nihongo.data.converter.MCQQuestionConverter;
import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.data.entity.question.Question;
import com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB;
import com.nihongo.support.constant.mongo.MongoDBKey.ExamKey;
import com.nihongo.support.constant.mongo.MongoOperator;
import com.nihongo.support.util.TransferData.RandomExamTransfer;

/**
 * 
 * @author DoanhNV Jul 7, 2018 8:56:05 PM
 */
@Repository
public class MCQQuestionDAOImpl implements MCQQuestionDAO {
	private static DBCollection mCQQuestionCollection = null;

	static {
		mCQQuestionCollection = EXAM_DATABASE.getCollection(EXAM_DB.MCQ_QUESTION_COLLECTION);
	}

	@Override
	public boolean insert(AbstractEntity entity) {
		MCQQuestion question = (MCQQuestion) entity;
		DBObject insertDBObject = MCQQuestionConverter.toInsertDBObject(question);
		mCQQuestionCollection.insert(insertDBObject);
		return true;
	}

	@Override
	public boolean update(AbstractEntity entity) {
		return false;
	}

	@Override
	public Question getById(String id) {
		return null;
	}

	@Override
	public List<Question> listAll() {
		List<Question> questions = new ArrayList<>();
		DBCursor cursor = mCQQuestionCollection.find();
		while(cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			MCQQuestion mCQQuestion = MCQQuestionConverter.toMCQQuestion(dbObject);
			questions.add(mCQQuestion);
		}
		return questions;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	@Override
	public Map<Integer, List<Question>> getRandomExam(int level, List<Integer> topics) {
		RandomExamTransfer transfer = new RandomExamTransfer(topics);
		Map<Integer, List<Question>> topicMap = transfer.getTopicMap();
		
		BasicDBObject findObject = new BasicDBObject();
		BasicDBObject insTopicObjet = new BasicDBObject(MongoOperator.$IN, topics);
		findObject.append(ExamKey.LEVEL, level);
		findObject.append(ExamKey.TOPIC, insTopicObjet);
		
		DBCursor cursor = mCQQuestionCollection.find(findObject);
		while(cursor.hasNext()) {
			MCQQuestion mcqQuestion = MCQQuestionConverter.toMCQQuestion(cursor.next());
			topicMap.get(mcqQuestion.getTopic()).add(mcqQuestion);
		}
		cursor.close();
		return topicMap;
	}

}
