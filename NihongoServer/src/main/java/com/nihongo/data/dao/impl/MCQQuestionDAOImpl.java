package com.nihongo.data.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.model.Aggregates;
import com.nihongo.data.converter.MCQQuestionConverter;
import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.data.entity.question.Question;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.dto.httpdto.request.MCQQuestionSearchRequest;
import com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB;
import com.nihongo.support.constant.mongo.MongoDBKey;
import com.nihongo.support.constant.mongo.MongoDBKey.ExamKey;
import com.nihongo.support.constant.mongo.MongoDBKey.MCQQuestionKey;
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
	public String insert(AbstractEntity entity) {
		MCQQuestion question = (MCQQuestion) entity;
		DBObject insertDBObject = MCQQuestionConverter.toInsertDBObject(question);
		mCQQuestionCollection.insert(insertDBObject);
		return insertDBObject.get(MCQQuestionKey.ID).toString();
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

	@Override
	public List<AbstractEntity> listAll() {
		List<AbstractEntity> questions = new ArrayList<>();
		DBCursor cursor = mCQQuestionCollection.find();
		while(cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			MCQQuestion mCQQuestion = MCQQuestionConverter.toMCQQuestion(dbObject);
			questions.add(mCQQuestion);
		}
		return questions;
	}
	
	@Override
	public SearchData search(AbstractSearchRequest request) {
		SearchData searchData = new SearchData();
		List<AbstractEntity> questions = new ArrayList<>();
		int total = 0;
		MCQQuestionSearchRequest searchRequest = (MCQQuestionSearchRequest) request;
		DBObject sortOjbect = MCQQuestionConverter.toSortOjbect(searchRequest.getSort());
		DBObject searchObject = MCQQuestionConverter.toSearchObject(request);
		
		DBCursor cursor = mCQQuestionCollection.find(searchObject);
		total = cursor.size();
		cursor = cursor.sort(sortOjbect);
		cursor = cursor.skip(searchRequest.getSkip()).limit(searchRequest.getTake());
		while(cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			MCQQuestion mCQQuestion = MCQQuestionConverter.toMCQQuestion(dbObject);
			questions.add(mCQQuestion);
		}
		searchData.setDatas(questions);
		searchData.setTotal(total);
		return searchData;
	}
	
	@Override
	public String delete(String id) {
		return null;
	}

	@Override
	public SearchData listByIds(List<String> questionIds) {
		SearchData searchData = new SearchData();
		List<AbstractEntity> questionIdList = new ArrayList<>();
		DBObject queryObject = MCQQuestionConverter.toListByIdsObject(questionIds);
		DBCursor cursor = mCQQuestionCollection.find(queryObject);
		while (cursor.hasNext()) {
			DBObject questionObject = cursor.next();
			MCQQuestion mcqQuestion = MCQQuestionConverter.toMCQQuestion(questionObject);
			questionIdList.add(mcqQuestion);
		}
		searchData.setDatas(questionIdList);
		return searchData;
	}

	public static void main(String[] args) {
		MCQQuestionDAOImpl mcqQuestionDAOImpl = new MCQQuestionDAOImpl();
		mcqQuestionDAOImpl.getRandomQuestions(5, 3);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public  List<MCQQuestion> getRandomQuestions(int level, int size) {
		List<MCQQuestion> mcqQuestions = new ArrayList<>();
		BasicDBObject conditionQuery = new BasicDBObject(MongoOperator.$MATCH, new BasicDBObject(MongoDBKey.LEVEL, level));
		BasicDBObject randomSizeQuery = new BasicDBObject(MongoOperator.$SAMPLE, new BasicDBObject(MongoOperator.SIZE, size));
		BasicDBObject projecttionQuery = new BasicDBObject(MongoOperator.$PROJECT, new BasicDBObject(MongoDBKey.ID, MongoOperator.INCLUDE_FIELD));
			
		AggregationOutput aggregation = mCQQuestionCollection.aggregate(
				Arrays.asList(
						conditionQuery,
						randomSizeQuery,
						projecttionQuery
				)
		);
		
		Iterable<DBObject> results = aggregation.results();
		for (DBObject dbObject : results) {
			System.out.println(dbObject.get("level") + " - "+  dbObject.get("_id").toString());
		}
		return null;
	}
}
