package com.nihongo.data.dao.impl;

import static com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB.EXAM_COLLECTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nihongo.data.converter.ExamConverter;
import com.nihongo.data.dao.ExamDAO;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.data.entity.other.transfer.SearchResult;
import com.nihongo.dto.httpdto.AbstractDTO;
import com.nihongo.dto.httpdto.entity.BasicExam;
import com.nihongo.dto.httpdto.entity.EndUserBasicExam;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.mongo.MongoDBKey;

/**
 * 
 * @author DoanhNV Jul 9, 2018 10:21:17 AM
 */
@Repository
public class ExamDAOImpl implements ExamDAO {

	private static DBCollection examCollection = EXAM_DATABASE.getCollection(EXAM_COLLECTION);

	@Override
	public boolean insert(Exam exam) {
		DBObject insertObject = ExamConverter.toInsertObject(exam);
		examCollection.insert(insertObject);
		return false;
	}

	@Override
	public SearchResult search(SearchExamRequest request) {
		SearchResult examDatas = new SearchResult();
		List<AbstractDTO> exams = new ArrayList<>();

		DBObject searchObject = ExamConverter.prepareSearchExaObject(request);
		DBObject sortOject = ExamConverter.prepareSortOject(request.getSort());
		DBCursor cursor = examCollection.find(searchObject);
		examDatas.setTotal(cursor.size());

		cursor = cursor.sort(sortOject).skip(request.getSkip()).limit(request.getTake());
		while (cursor.hasNext()) {
			DBObject examObject = cursor.next();
			BasicExam exam = ExamConverter.toBasicExam(examObject);
			exams.add(exam);
		}
		examDatas.setDatas(exams);
		return examDatas;
	}

	@Override
	public Exam getExam(String id, int clientQueryMode) {
		Exam exam = null;
		DBObject queryObject = ExamConverter.prepareObjectId(id);
		DBObject examObject = examCollection.findOne(queryObject);
		if (examObject != null) {
			exam = ExamConverter.toExam(examObject, clientQueryMode);
		}
		return exam;
	}

	@Override
	public boolean update(String id, Boolean isActive, Boolean isFree, Boolean isTrial, Integer point,
			Integer completedMinutes) {
		DBObject queryObject = ExamConverter.prepareObjectId(id);
		DBObject updateObject = ExamConverter.prepareUpdateObject(isActive, isFree, isTrial, point, completedMinutes);
		examCollection.update(queryObject, updateObject);
		return true;
	}

	@Override
	public SearchResult listExam(Integer level, Integer examType, int skip, int take) {
		List<AbstractDTO> datas = new ArrayList<>();
		BasicDBObject queryObject = ExamConverter.prepareListExamObject(level);
		BasicDBObject sortObject = null;
		final int DESC_ORDER = 1;
		examType = examType == null ? Constant.QUERY_PROPERTIES.QUERY_ALL : examType;
		
		switch (examType) {
			case Constant.EXAM_TYPE.TRIAL:
				queryObject.append(MongoDBKey.ExamKey.IS_TRIAL, true);
				break;
			case Constant.EXAM_TYPE.FREE:
				queryObject.append(MongoDBKey.ExamKey.IS_FREE, true);
				break;
			case Constant.EXAM_TYPE.LATEST:
				sortObject = new BasicDBObject(MongoDBKey.ExamKey.ID, DESC_ORDER);
				break;
			case Constant.EXAM_TYPE.BEST_TAKED:
				sortObject = new BasicDBObject(MongoDBKey.ExamKey.TAKED_NUMBER, DESC_ORDER);
				break;
		}
		
		DBCursor cursor = examCollection.find(queryObject);
		if(sortObject != null) {
			cursor.sort(sortObject);
		}
		cursor.skip(skip).limit(take);
		while(cursor.hasNext()) {
			EndUserBasicExam endUserBasicExam = ExamConverter.toEndUserBasicExam(cursor.next());
			datas.add(endUserBasicExam);
		}
		
		return new SearchResult(datas);
	}

	@Override
	public void encreaseLikeNumber(String examId) {
		final int ENCREASE_LIKE_NUMBER = 1;
		DBObject query = ExamConverter.prepareObjectId(examId);
		BasicDBObject encreaseobject = ExamConverter.prepareEncreaseLike(ENCREASE_LIKE_NUMBER);
		examCollection.update(query, encreaseobject);
	}

	@Override
	public void decreaseLikeNumber(String examId) {
		final int ENCREASE_LIKE_NUMBER = -1;
		DBObject query = ExamConverter.prepareObjectId(examId);
		BasicDBObject encreaseobject = ExamConverter.prepareEncreaseLike(ENCREASE_LIKE_NUMBER);
		examCollection.update(query, encreaseobject);
	}

	@Override
	public SearchResult listFavoriteExam(List<String> examIds) {
		List<AbstractDTO> datas = new ArrayList<>();
		BasicDBObject queryObject = ExamConverter.prepareListFavoriteExamObject(examIds);
		DBCursor cursor = examCollection.find(queryObject);
		while(cursor.hasNext()) {
			EndUserBasicExam endUserBasicExam = ExamConverter.toEndUserBasicExam(cursor.next());
			datas.add(endUserBasicExam);
		}
		
		return new SearchResult(datas);
	}

	@Override
	public SearchResult listHistoryExam(List<String> examIds) {
		List<AbstractDTO> datas = new ArrayList<>();
		BasicDBObject queryObject = ExamConverter.prepareListFavoriteExamObject(examIds);
		DBCursor cursor = examCollection.find(queryObject);
		Map<String, EndUserBasicExam> exams = new HashMap<>();
		
		while(cursor.hasNext()) {
			EndUserBasicExam endUserBasicExam = ExamConverter.toEndUserBasicExam(cursor.next());
			exams.put(endUserBasicExam.getId(), endUserBasicExam);
		}
		
		for (String examId : examIds) {
			datas.add(exams.get(examId));
		}
		return new SearchResult(datas);
	}
}
