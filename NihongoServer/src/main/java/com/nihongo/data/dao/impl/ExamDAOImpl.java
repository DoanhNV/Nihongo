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
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.data.entity.other.transfer.SearchData;
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
	public SearchData search(SearchExamRequest request) {
		SearchData examDatas = new SearchData();
		List<AbstractEntity> exams = new ArrayList<>();
		
		DBObject searchObject = ExamConverter.prepareSearchExaObject(request);
		DBObject sortOject = ExamConverter.prepareSortOject(request.getSort());
		DBCursor cursor = examCollection.find(searchObject);
		examDatas.setTotal(cursor.size());
		
		cursor = cursor.sort(sortOject).skip(request.getSkip()).limit(request.getTake());
		while (cursor.hasNext()) {
			DBObject examObject = cursor.next();
			Exam exam = ExamConverter.toExam(examObject);
			exams.add(exam);
		}
		examDatas.setDatas(exams);
		return examDatas;
	}
}
