package com.nihongo.service.data;
/**
 * 
 * @author DoanhNV Jul 9, 2018 11:09:57 AM
 */

import java.util.List;

import com.nihongo.data.entity.other.transfer.SearchResult;
import com.nihongo.dto.httpdto.entity.DetailExam;
import com.nihongo.dto.httpdto.entity.RandomExamDTO;
import com.nihongo.dto.httpdto.request.SearchExamRequest;

public interface ExamService {
	
	public List<RandomExamDTO> getRandomExam(int level, List<Integer> topics);
	
	public boolean createRandomExam(int level);
	
	public SearchResult search(SearchExamRequest request);
	
	public DetailExam getDetail(String id, int clientQueryMode);
}
