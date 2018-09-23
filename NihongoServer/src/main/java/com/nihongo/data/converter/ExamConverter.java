package com.nihongo.data.converter;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.Sort;
import com.nihongo.data.entity.exam.EmbedExamTopic;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.dto.httpdto.entity.BasicExam;
import com.nihongo.dto.httpdto.entity.EndUserBasicExam;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.support.RequestValidator;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.mongo.MongoDBKey;
import com.nihongo.support.constant.mongo.MongoOperator;

import static com.nihongo.support.constant.Constant.QUERY_PROPERTIES.*;
import static com.nihongo.support.constant.mongo.MongoDBKey.ExamKey.*;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 9:47:10 PM
 *
 */
public class ExamConverter {

	public static DBObject toInsertObject(Exam exam) {
		BasicDBObject insertObject = new BasicDBObject();
		insertObject.append(MongoDBKey.ExamKey.IS_ACTIVE, exam.isActive());
		insertObject.append(MongoDBKey.ExamKey.IS_TRIAL, exam.isTrial());
		insertObject.append(MongoDBKey.ExamKey.IS_FREE, exam.isFree());
		insertObject.append(MongoDBKey.ExamKey.LEVEL, exam.getLevel());
		insertObject.append(MongoDBKey.ExamKey.POINT, exam.getPoint());
		insertObject.append(MongoDBKey.ExamKey.LIKE_NUMBER, exam.getLikeNumber());
		insertObject.append(MongoDBKey.ExamKey.TAKED_NUMBER, exam.getTakedNumber());
		insertObject.append(MongoDBKey.ExamKey.CREATE_TIME, exam.getCreateTime());
		insertObject.append(MongoDBKey.ExamKey.UPDATE_TIME, exam.getUpdateTime());
		insertObject.append(MongoDBKey.ExamKey.COMPLETED_MINUTES, exam.getCompletedMinutes());
		
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

	public static DBObject prepareSearchExaObject(SearchExamRequest request) {
		final Boolean QUERY_ALL = null;
		BasicDBObject searchObject = new BasicDBObject();
		if(request.getLevel() != Constant.QUERY_PROPERTIES.QUERY_ALL) {
			searchObject.append(MongoDBKey.LEVEL, request.getLevel());
		}
		if(request.getIsTrial() != QUERY_ALL) {
			searchObject.append(MongoDBKey.ExamKey.IS_TRIAL, request.getIsTrial());
		}
		if(request.getIsFree() != QUERY_ALL) {
			searchObject.append(MongoDBKey.ExamKey.IS_FREE, request.getIsFree());
		}
		return searchObject;
	}
	
	public static DBObject prepareUpdateObject(Boolean isActive, Boolean isFree, Boolean isTrial, Integer point, Integer completedMinutes) {
		BasicDBObject fieldUpdateObject = new  BasicDBObject();
		if (isActive != null) {
			fieldUpdateObject.append(MongoDBKey.ExamKey.IS_ACTIVE, isActive);
		}
		if (isFree != null) {
			fieldUpdateObject.append(MongoDBKey.ExamKey.IS_FREE, isFree);
		}
		if (isTrial != null) {
			fieldUpdateObject.append(MongoDBKey.ExamKey.IS_TRIAL, isTrial);
		}
		if (point != null) {
			fieldUpdateObject.append(MongoDBKey.ExamKey.POINT, point);
		}
		if (completedMinutes != null) {
			fieldUpdateObject.append(MongoDBKey.ExamKey.COMPLETED_MINUTES, completedMinutes);
		}
		long currentTimeMillis = System.currentTimeMillis();
		fieldUpdateObject.append(MongoDBKey.ExamKey.UPDATE_TIME, currentTimeMillis);
		return new BasicDBObject(MongoOperator.$SET, fieldUpdateObject);
	}
	
	public static DBObject prepareSortOject(Sort sort) {
		BasicDBObject sortObject = new BasicDBObject(DEFAULT_SORT_FIELD, DEFAULT_SORT_VALUE);
		if(RequestValidator.isValidSortRequest(sort)) {
			sortObject = new BasicDBObject(sort.getFieldName(), sort.getOrder());
		}
		return sortObject;
	}
	
	public static DBObject prepareObjectId(String id) {
		ObjectId objectId = new ObjectId(id);
		return new BasicDBObject(MongoDBKey.ExamKey.ID, objectId);
	}
	
	public static BasicDBObject prepareListExamObject(int level) {
		BasicDBObject queryObject = new BasicDBObject(LEVEL, level);
		queryObject.append(IS_ACTIVE, true);
		return queryObject;
	}
	
	public static EndUserBasicExam toEndUserBasicExam(DBObject examObject) {
		EndUserBasicExam exam = new EndUserBasicExam();
		
		String id = examObject.get(MongoDBKey.ExamKey.ID).toString();
		Integer level = (Integer) examObject.get(MongoDBKey.ExamKey.LEVEL);
		Integer likeNumber = (Integer) examObject.get(MongoDBKey.ExamKey.LIKE_NUMBER);
		Integer takedNumber = (Integer) examObject.get(MongoDBKey.ExamKey.TAKED_NUMBER);
		Boolean isFree = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_FREE);
		
		exam.setId(id);
		exam.setFree(isFree);
		exam.setLevel(level);
		exam.setTakedNumber(takedNumber);
		exam.setLikeNumber(likeNumber);
		return exam;
	}
	
	public static BasicExam toBasicExam(DBObject examObject) {
		BasicExam exam = new BasicExam();
		
		String id = examObject.get(MongoDBKey.ExamKey.ID).toString();
		Long createTime = (Long) examObject.get(MongoDBKey.ExamKey.CREATE_TIME);
		Long updateTime = (Long) examObject.get(MongoDBKey.ExamKey.UPDATE_TIME);
		Integer level = (Integer) examObject.get(MongoDBKey.ExamKey.LEVEL);
		Integer point = (Integer) examObject.get(MongoDBKey.ExamKey.POINT);
		Integer likeNumber = (Integer) examObject.get(MongoDBKey.ExamKey.LIKE_NUMBER);
		Integer takedNumber = (Integer) examObject.get(MongoDBKey.ExamKey.TAKED_NUMBER);
		Integer completedMinutes = (Integer) examObject.get(MongoDBKey.ExamKey.COMPLETED_MINUTES);
		Boolean isTrial = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_TRIAL);
		Boolean isFree = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_FREE);
		Boolean isActive = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_ACTIVE);
		
		exam.setId(id);
		exam.setActive(isActive);
		exam.setTrial(isTrial);
		exam.setFree(isFree);
		exam.setLevel(level);
		exam.setPoint(point);
		exam.setTakedNumber(takedNumber);
		exam.setLikeNumber(likeNumber);
		exam.setCompletedMinutes(completedMinutes);
		exam.setCreateTime(createTime);
		exam.setUpdateTime(updateTime);
		return exam;
	}
	
	public static Exam toExam(DBObject examObject, int clientQueryMode) {
		Exam exam = new Exam();
		
		String id = examObject.get(MongoDBKey.ExamKey.ID).toString();
		Long createTime = (Long) examObject.get(MongoDBKey.ExamKey.CREATE_TIME);
		Integer level = (Integer) examObject.get(MongoDBKey.ExamKey.LEVEL);
		Integer point = (Integer) examObject.get(MongoDBKey.ExamKey.POINT);
		Integer likeNumber = (Integer) examObject.get(MongoDBKey.ExamKey.LIKE_NUMBER);
		Integer takedNumber = (Integer) examObject.get(MongoDBKey.ExamKey.TAKED_NUMBER);
		Integer completedMinutes = (Integer) examObject.get(MongoDBKey.ExamKey.COMPLETED_MINUTES);
		Boolean isTrial = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_TRIAL);
		Boolean isFree = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_FREE);
		Boolean isActive = null;
		Long updateTime = null;
		
		if(clientQueryMode == Constant.CLIENT_QUERY_MODE.BACKEND_MODE) {
			isActive = (Boolean) examObject.get(MongoDBKey.ExamKey.IS_ACTIVE);
			updateTime = (Long) examObject.get(MongoDBKey.ExamKey.UPDATE_TIME);
			exam.setActive(isActive);
			exam.setUpdateTime(updateTime);
		}
		
		
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
		exam.setTrial(isTrial);
		exam.setFree(isFree);
		exam.setLevel(level);
		exam.setPoint(point);
		exam.setLikeNumber(likeNumber);
		exam.setTakedNumber(takedNumber);
		exam.setCompletedMinutes(completedMinutes);
		exam.setCreateTime(createTime);
		exam.setEmbedExamTopics(embedTopics);
		return exam;
	}
}
