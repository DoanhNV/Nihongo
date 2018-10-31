package com.nihongo.controller.function;

import static com.nihongo.support.util.EntityUtil.castToMCQQuestionObject;
import static com.nihongo.support.util.EntityUtil.transferObjectTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.dto.httpdto.request.DeleteMCQQuestionRequest;
import com.nihongo.dto.httpdto.request.InsertMCQQuestionRequest;
import com.nihongo.dto.httpdto.request.MCQQuestionListByIdsRequest;
import com.nihongo.dto.httpdto.request.MCQQuestionSearchRequest;
import com.nihongo.dto.httpdto.request.UpdateMCQQuestionRequest;
import com.nihongo.dto.httpdto.response.DeleteMCQQuestionResponse;
import com.nihongo.dto.httpdto.response.InsertMCQQuestionResponse;
import com.nihongo.dto.httpdto.response.MCQQuestionListByIdsResponse;
import com.nihongo.dto.httpdto.response.MCQQuestionSearchResponse;
import com.nihongo.dto.httpdto.response.UpdateMCQQuestionResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.MCQQuestionService;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 7, 2018 9:49:57 PM
 */
@RestController
@RequestMapping(value = API.MCQ_QUESTION.ROOT)
@CrossOrigin
public class MCQQuestionController {

	@Autowired
	private MCQQuestionService mCQQuestionService;

	@PostMapping(value = API.MCQ_QUESTION.CREATE)
	@ResponseBody
	public InsertMCQQuestionResponse create(@RequestBody InsertMCQQuestionRequest request) {
		InsertMCQQuestionResponse response = new InsertMCQQuestionResponse();
		try {
			MCQQuestion mcqQuestion = new MCQQuestion();
			transferObjectTo(request, mcqQuestion);
			String mcqQuestionId = mCQQuestionService.insert(mcqQuestion);
			response.setInsertMCQQuestionResponse(ResponseCode.SUCCESS, mcqQuestionId);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PutMapping (value = API.MCQ_QUESTION.UPDATE)
	@ResponseBody
	public UpdateMCQQuestionResponse update (@RequestBody UpdateMCQQuestionRequest request) {
		UpdateMCQQuestionResponse response = new UpdateMCQQuestionResponse();
		try {
			MCQQuestion mcqQuestion = new MCQQuestion();
			transferObjectTo(request, mcqQuestion);
			mCQQuestionService.update(mcqQuestion);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@DeleteMapping (value = API.MCQ_QUESTION.DELETE)
	@ResponseBody
	public DeleteMCQQuestionResponse delete(@RequestBody DeleteMCQQuestionRequest request) {
		DeleteMCQQuestionResponse response = new DeleteMCQQuestionResponse();
		try {
			mCQQuestionService.delete(request.getId());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}

	@PostMapping(value = API.MCQ_QUESTION.SEARCH)
	@ResponseBody
	public MCQQuestionSearchResponse listAll(@RequestBody MCQQuestionSearchRequest request) {
		MCQQuestionSearchResponse response = new MCQQuestionSearchResponse(ResponseCode.SYSTEM_ERROR);
		try {
			SearchData searchData = mCQQuestionService.search(request);
			List<MCQQuestion> questions = castToMCQQuestionObject(searchData.getDatas());
			response.setResponseData(ResponseCode.SUCCESS, questions, searchData.getTotal());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = API.MCQ_QUESTION.LIST)
	@ResponseBody
	public MCQQuestionListByIdsResponse listByIds(@RequestBody MCQQuestionListByIdsRequest request) {
		MCQQuestionListByIdsResponse response = new MCQQuestionListByIdsResponse(ResponseCode.SYSTEM_ERROR);
		try {
			 SearchData searchData = mCQQuestionService.listByIds(request.getQuestionIds());
			 List<MCQQuestion> questions = castToMCQQuestionObject(searchData.getDatas());
			 response.setResponseData(ResponseCode.SUCCESS, questions, searchData.getTotal());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
}
