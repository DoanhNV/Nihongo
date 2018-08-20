package com.nihongo.service.data;

import java.util.List;

import com.nihongo.data.entity.other.transfer.SearchData;

/**
 * 
 * @author DoanhNV Jul 7, 2018 9:25:51 PM
 */
public interface MCQQuestionService extends IService {
	
	public SearchData listByIds(List<String> questionIds);
}
