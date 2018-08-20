package com.nihongo.service.data;
/**
 * 
 * @author DoanhNV Jul 9, 2018 11:09:57 AM
 */

import java.util.List;

import com.nihongo.dto.httpdto.RandomExamDTO;

public interface ExamService extends IService {
	
	public List<RandomExamDTO> getRandomExam(int level, List<Integer> topics);
}
