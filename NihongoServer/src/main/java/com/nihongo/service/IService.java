package com.nihongo.service;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:45 AM
 */
public interface IService {
	
	public boolean insert(AbstractEntity entity);

	public boolean update(AbstractEntity entity);

	public AbstractEntity getById(String id);

	public List<AbstractEntity> listAll();
	
	public SearchData search(AbstractSearchRequest request);
	
	public boolean delete(String id);
}
