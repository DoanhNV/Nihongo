package com.nihongo.service.data;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.dto.httpdto.request.AbstractSearchRequest;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:45 AM
 */
public interface IService {
	
	public String insert(AbstractEntity entity);

	public boolean update(AbstractEntity entity);

	public AbstractEntity getById(String id);

	public List<AbstractEntity> listAll();
	
	public SearchData search(AbstractSearchRequest request);
	
	public String delete(String id);
}