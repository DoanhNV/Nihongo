package com.nihongo.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.nihongo.data.converter.MCQQuestionConverter;
import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.data.entity.question.Question;
import com.nihongo.support.constant.mongo.MongoConfigInfo.*;

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
		return null;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

}
