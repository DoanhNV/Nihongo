package com.nihongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.nihongo.httpdto.response.MCQQuestionResponse.*;
import com.nihongo.service.MCQQuestionService;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.httpdto.request.MCQQuestionRequest;
import static com.nihongo.support.util.EntityUtil.*;

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
	public CreatResponse create(@RequestBody MCQQuestionRequest request) {
		CreatResponse response = new CreatResponse(ResponseCode.SYSTEM_ERROR);
		try {
			request.setTitle(new String(request.getTitle().getBytes("UTF-8"), "UTF-8"));
			MCQQuestion mcqQuestion = new MCQQuestion();
			transferObjectTo(request, mcqQuestion);
			mCQQuestionService.insert(mcqQuestion);
			response.setCode(ResponseCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
