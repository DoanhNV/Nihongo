package com.nihongo.data.dao.impl;

import static com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB.EXAM_COLLECTION;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nihongo.data.converter.ExamConverter;
import com.nihongo.data.dao.ExamDAO;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.data.entity.other.transfer.SearchResult;
import com.nihongo.dto.httpdto.AbstractDTO;
import com.nihongo.dto.httpdto.entity.BasicExam;
import com.nihongo.dto.httpdto.request.SearchExamRequest;

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
		if(examObject != null) {
			exam = ExamConverter.toExam(examObject, clientQueryMode);
		}
		return exam;
	}

	@Override
	public boolean update(String id, Boolean isActive, Boolean isFree, Boolean isTrial, Integer point, Integer completedMinutes) {
		DBObject queryObject = ExamConverter.prepareObjectId(id);
		DBObject updateObject = ExamConverter.prepareUpdateObject(isActive, isFree, isTrial, point, completedMinutes);
		examCollection.update(queryObject, updateObject);
		return true;
	}
}
