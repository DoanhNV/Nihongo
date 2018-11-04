package com.nihongo.service.data;

import java.util.List;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:51:47 AM
 */
public interface DocumentService extends IService {
	
	public List<String> listQuestionByExamId(String examId);
}
