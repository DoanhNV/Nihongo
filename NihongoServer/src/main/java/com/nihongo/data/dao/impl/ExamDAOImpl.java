package com.nihongo.data.dao.impl;

import static com.nihongo.support.constant.mongo.MongoConfigInfo.EXAM_DB.EXAM_COLLECTION;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.nihongo.data.dao.ExamDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.Question;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;

/**
 * 
 * @author DoanhNV Jul 9, 2018 10:21:17 AM
 */
@Repository
public class ExamDAOImpl implements ExamDAO {
	private static DBCollection examCollection = null;
	
	static {
		examCollection = EXAM_DATABASE.getCollection(EXAM_COLLECTION);
	}

	@Override
	public boolean insert(AbstractEntity entity) {
		return false;
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
	public boolean delete(String id) {
		return false;
	}

	@Override
	public List<AbstractEntity> listAll() {
		return null;
	}

	@Override
	public SearchData search(AbstractSearchRequest request) {
		return null;
	}
}
