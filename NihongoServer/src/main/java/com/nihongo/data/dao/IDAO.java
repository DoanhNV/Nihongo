package com.nihongo.data.dao;

import java.util.List;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:29 AM
 */
public interface IDAO {
	
	public static final DB EXAM_DATABASE = MongoDBConnection.getDatabase(MongoConfigInfo.EXAM_DB);
	
	public boolean insert(AbstractEntity entity);

	public boolean update(AbstractEntity entity);

	public AbstractEntity getById(String id);

	public List<AbstractEntity> listAll();
	
	public SearchData search(AbstractSearchRequest request);

	public boolean delete(String id);
}
