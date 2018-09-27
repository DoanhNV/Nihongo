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
	
	public DetailExam getDetail(String id, int clientQueryMode);
	
	public List<RandomExamDTO> getRandomExam(int level, List<Integer> topics);
	
	public boolean createRandomExam(int level);
	
	public boolean udpate(String id, Boolean isActive, Boolean isFree, Boolean isTrial, Integer point, Integer completedMinutes);
	
	public SearchResult search(SearchExamRequest request);
	
	public SearchResult listExam(int level, int examType, int skip, int take);
	
	public SearchResult listFavoriteExam(String userId, int skip, int take);
	
	public void encreaseLikeNumber (String examId);
	
	public void decreaseLikeNumber (String examId);
}
