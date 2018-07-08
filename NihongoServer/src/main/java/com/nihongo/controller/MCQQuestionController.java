package com.nihongo.controller;

import static com.nihongo.support.util.EntityUtil.transferObjectTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.httpdto.request.InsertMCQQuestionRequest;
import com.nihongo.httpdto.response.InsertMCQQuestionResponse;
import com.nihongo.service.MCQQuestionService;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 7, 2018 9:49:57 PM
 */
@RestController
@RequestMapping(value = "/mvcquestion")
public class MCQQuestionController {
	
	@Autowired
	private MCQQuestionService mCQQuestionService;
	
	@PostMapping(value = "/create")
	@ResponseBody
	public InsertMCQQuestionResponse create(@RequestBody InsertMCQQuestionRequest request) {
		InsertMCQQuestionResponse response = new InsertMCQQuestionResponse();
		try {
			MCQQuestion mcqQuestion = new MCQQuestion();
			transferObjectTo(request, mcqQuestion);
			mCQQuestionService.insert(mcqQuestion);
			response.setCode(ResponseCode.SUCCESS);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
}
