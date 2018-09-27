package com.nihongo.controller.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.dto.httpdto.request.ExamFavoriteRequest;
import com.nihongo.dto.httpdto.request.ExamLikeRequest;
import com.nihongo.dto.httpdto.request.ExamUnLikeRequest;
import com.nihongo.dto.httpdto.request.ExamUnfavoriteRequest;
import com.nihongo.dto.httpdto.response.ExamLikeResponse;
import com.nihongo.dto.httpdto.response.ExamUnLikeResponse;
import com.nihongo.dto.httpdto.response.ExamUnfavoriteResponse;
import com.nihongo.dto.httpdto.response.ExamFavoriteResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.ExamFavoriteService;
import com.nihongo.service.data.ExamLikeService;
import com.nihongo.service.data.ExamService;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Sep 27, 2018 3:55:19 PM
 *
 */

@CrossOrigin
@RestController
@RequestMapping(value = API.USER.ROOT)
public class UserConnection {

	@Autowired
	private ExamLikeService examLikeService;
	@Autowired
	private ExamFavoriteService examFavoriteService;
	@Autowired
	private ExamService examService;

	@PutMapping(value = "/like")
	@ResponseBody
	public ExamLikeResponse likeExam(@RequestBody ExamLikeRequest request) {
		ExamLikeResponse response = new ExamLikeResponse();
		try {
			examLikeService.likeExam(request.getUserId(), request.getExamId());
			examService.encreaseLikeNumber(request.getExamId());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}

	@PutMapping(value = "/unlike")
	@ResponseBody
	public ExamUnLikeResponse unlikeExam(@RequestBody ExamUnLikeRequest request) {
		ExamUnLikeResponse response = new ExamUnLikeResponse();
		try {
			examLikeService.unlikeExam(request.getUserId(), request.getExamId());
			examService.decreaseLikeNumber(request.getExamId());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PutMapping(value = "/favorite")
	@ResponseBody
	public ExamFavoriteResponse favoriteExam(@RequestBody ExamFavoriteRequest request) {
		ExamFavoriteResponse response = new ExamFavoriteResponse();
		try {
			examFavoriteService.favoriteExam(request.getUserId(), request.getExamId());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PutMapping(value = "/unfavorite")
	@ResponseBody
	public ExamUnfavoriteResponse favoriteExam(@RequestBody ExamUnfavoriteRequest request) {
		ExamUnfavoriteResponse response = new ExamUnfavoriteResponse();
		try {
			examFavoriteService.unfavoriteExam(request.getUserId(), request.getExamId());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
}
