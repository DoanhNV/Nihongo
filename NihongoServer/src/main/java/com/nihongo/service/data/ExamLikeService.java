package com.nihongo.service.data;

/**
 * 
 * @author DoanhNV Sep 27, 2018 4:39:07 PM
 *
 */
public interface ExamLikeService {
	
	public boolean likeExam(String userId, String examId);
	
	public boolean unlikeExam(String userId, String examId);
}
