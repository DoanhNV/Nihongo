package com.nihongo.service;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.question.Question;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:45 AM
 */
public interface IService {
	
	public boolean insert(AbstractEntity entity);

	public boolean update(AbstractEntity entity);

	public Question getById(String id);

	public List<Question> listAll();

	public boolean delete(String id);
}
