package com.nihongo.service.data;

import java.util.List;

import com.nihongo.dto.httpdto.AbstractDTO;
import com.nihongo.dto.httpdto.entity.DetailEndUserExam;

/**
 * 
 * @author DoanhNV Sep 27, 2018 4:39:07 PM
 *
 */
public interface ExamLikeService {
	
	public boolean doLikeExamAction(String userId, String examId);
	
	public void processLikeStatus(String userId, List<AbstractDTO> endUserExams);
	
	public void processLikeStatus(String userId, DetailEndUserExam exam);
}
