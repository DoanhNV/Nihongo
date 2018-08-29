package com.nihongo.data.converter;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.Sort;
import com.nihongo.data.entity.exam.EmbedExamTopic;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.support.RequestValidator;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.mongo.MongoDBKey;
import static com.nihongo.support.constant.Constant.QUERY_PROPERTIES.*;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 9:47:10 PM
 *
 */
public class ExamConverter {

	public static DBObject toInsertObject(Exam exam) {
		BasicDBObject insertObject = new BasicDBObject();
		insertObject.append(MongoDBKey.ExamKey.LEVEL, exam.getLevel());
		insertObject.append(MongoDBKey.ExamKey.IS_TRIAL, exam.isTrial());
		insertObject.append(MongoDBKey.ExamKey.IS_FREE, exam.isFree());
		insertObject.append(MongoDBKey.ExamKey.LIKE_NUMBER, exam.getLikeNumber());
		insertObject.append(MongoDBKey.ExamKey.CREATE_TIME, exam.getCreateTime());
		insertObject.append(MongoDBKey.ExamKey.UPDATE_TIME, exam.getUpdateTime());

		List<EmbedExamTopic> embedExamTopics = exam.getEmbedExamTopics();
		BasicDBList listEmbedTopic = new BasicDBList();
		for (EmbedExamTopic embedExamTopic : embedExamTopics) {
			BasicDBObject embedTopic = new BasicDBObject(MongoDBKey.TOPIC, embedExamTopic.getTopic())
												 .append(MongoDBKey.QUESTION_IDS, embedExamTopic.getMcqQuestionIds());
			listEmbedTopic.add(embedTopic);
		}
		insertObject.append(MongoDBKey.ExamKey.EMBED_TOPIC, listEmbedTopic);
		return insertObject;
	}

	public static Exam toExam(DBObject examObject) {
		Exam exam = new Exam();
		Integer level = (Integer) examObject.get(MongoDBKey.ExamKey.LEVEL);
		String id = examObject.get(MongoDBKey.ExamKey.ID).toString();
		Boolean isTrial = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_TRIAL);
		Boolean isFree = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_FREE);
		Integer likeNumber = (Integer) examObject.get(MongoDBKey.ExamKey.LIKE_NUMBER);
		Long createTime = (Long) examObject.get(MongoDBKey.ExamKey.CREATE_TIME);
		Long updateTime = (Long) examObject.get(MongoDBKey.ExamKey.UPDATE_TIME);
		
		List<EmbedExamTopic> embedTopics = new ArrayList<>();
		BasicDBList listEmbedTopic = (BasicDBList) examObject.get(MongoDBKey.ExamKey.EMBED_TOPIC);
		for (Object item : listEmbedTopic) {
			BasicDBObject embedTopicObject = (BasicDBObject) item;
			Integer topic = (Integer) embedTopicObject.get(MongoDBKey.TOPIC);
			BasicDBList listQuestionIds = (BasicDBList) embedTopicObject.get(MongoDBKey.QUESTION_IDS);
			List<String> questionIds = new ArrayList<>();
			for (Object questionId : listQuestionIds) {
				 questionIds.add((String) questionId); 
			}
			EmbedExamTopic embedExamTopic = new EmbedExamTopic(topic, questionIds);
			embedTopics.add(embedExamTopic);
		}
		
		exam.setId(id);
		exam.setLevel(level);
		exam.setTrial(isTrial);
		exam.setFree(isFree);
		exam.setLikeNumber(likeNumber);
		exam.setCreateTime(createTime);
		exam.setUpdateTime(updateTime);
		exam.setEmbedExamTopics(embedTopics);
		return exam;
	}
	
	
	public static DBObject prepareSearchExaObject(SearchExamRequest request) {
		BasicDBObject searchObject = new BasicDBObject();
		if(request.getLevel() != Constant.QUERY_PROPERTIES.QUERY_ALL) {
			searchObject.append(MongoDBKey.LEVEL, request.getLevel());
		}
		searchObject.append(MongoDBKey.ExamKey.IS_TRIAL, request.isTrial());
		searchObject.append(MongoDBKey.ExamKey.IS_FREE, request.isFree());
		
		return searchObject;
	}
	
	public static DBObject prepareSortOject(Sort sort) {
		BasicDBObject sortObject = new BasicDBObject(DEFAULT_SORT_FIELD, DEFAULT_SORT_VALUE);
		if(RequestValidator.isValidSortRequest(sort)) {
			sortObject = new BasicDBObject(sort.getFieldName(), sort.getOrder());
		}
		return sortObject;
	}
}
