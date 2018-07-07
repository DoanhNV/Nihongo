package com.nihongo.data.dao;

import java.util.List;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.question.Question;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:29 AM
 */
public interface IDAO {
	
	public static final DB EXAM_DATABASE = MongoDBConnection.getDatabase(MongoConfigInfo.EXAM_DB);
	
	public boolean insert(AbstractEntity entity);

	public boolean update(AbstractEntity entity);

	public Question getById(String id);

	public List<Question> listAll();

	public boolean delete(String id);
	
}
