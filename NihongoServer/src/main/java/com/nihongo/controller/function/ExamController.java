package com.nihongo.controller.function;

import static com.nihongo.support.constant.Constant.MAX_TOPIC_PER_EXAM;
import static com.nihongo.support.constant.Constant.MAX_TOPIC_NUMBER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.entity.other.transfer.SearchResult;
import com.nihongo.dto.httpdto.entity.BasicExam;
import com.nihongo.dto.httpdto.entity.DetailEndUserExam;
import com.nihongo.dto.httpdto.entity.DetailExam;
import com.nihongo.dto.httpdto.entity.RandomExamDTO;
import com.nihongo.dto.httpdto.request.ListExamRequest;
import com.nihongo.dto.httpdto.request.ListExamResponse;
import com.nihongo.dto.httpdto.request.ListFavoriteExamRequest;
import com.nihongo.dto.httpdto.request.RandomCreateExamRequest;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.dto.httpdto.request.UpdateExamRequest;
import com.nihongo.dto.httpdto.response.SearchExamResponse;
import com.nihongo.dto.httpdto.response.UpdateExamResponse;
import com.nihongo.dto.httpdto.response.DetailExamResponse;
import com.nihongo.dto.httpdto.response.RandomCreateExamResponse;
import com.nihongo.dto.httpdto.response.RandomExamResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.ExamFavoriteService;
import com.nihongo.service.data.ExamLikeService;
import com.nihongo.service.data.ExamService;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.support.util.EntityUtil;
import com.nihongo.support.util.NihongoUtil;

/**
 * 
 * @author DoanhNV Jul 9, 2018 10:18:09 AM
 */
@RequestMapping(value = API.EXAM.ROOT)
@RestController
@CrossOrigin
public class ExamController {
	
	@Autowired
	private ExamService examService;
	@Autowired
	private ExamLikeService examLikeService;
	@Autowired
	private ExamFavoriteService examFavoriteService;
	
	@GetMapping(value = API.EXAM.GET_RANDOM_EXAM)
	@ResponseBody
	public RandomExamResponse getRandomExam(@PathVariable int level) {
		RandomExamResponse response = new RandomExamResponse();
		try {
			List<Integer> topics = NihongoUtil.randomNumberList(0, MAX_TOPIC_NUMBER, MAX_TOPIC_PER_EXAM);
			List<RandomExamDTO> exams = examService.getRandomExam(level, topics);
			response.setExams(exams);
			response.setCode(ResponseCode.SUCCESS);
		}  catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		}  catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = API.EXAM.CREATE_RANDOM_EXAM)
	@ResponseBody
	public RandomCreateExamResponse createRandom(@RequestBody RandomCreateExamRequest request) {
		RandomCreateExamResponse response = new RandomCreateExamResponse(ResponseCode.SUCCESS);
		try {
			examService.createRandomExam(request.getLevel());
		}  catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		}  catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = API.EXAM.SEARCH)
	@ResponseBody
	public SearchExamResponse searchExams(@RequestBody SearchExamRequest request) {
		SearchExamResponse response = new SearchExamResponse();
		try {
			SearchResult searchResult = examService.search(request);
			List<BasicExam> exams = EntityUtil.castBasicExamObject(searchResult.getDatas());
			response.setResponseData(ResponseCode.SUCCESS, searchResult.getTotal(), exams);
		}  catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		}  catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@GetMapping(value = API.EXAM.DETAIL)
	@ResponseBody
	public DetailExamResponse getDetail(@PathVariable String id, @PathVariable int clientQueryMode, HttpServletRequest request) {
		DetailExamResponse response = new DetailExamResponse();
		try {
			DetailExam detailExam = examService.getDetail(id, clientQueryMode);
			boolean isNormalUserRequest = clientQueryMode != Constant.CLIENT_QUERY_MODE.BACKEND_MODE;
			
			if (isNormalUserRequest) {
				String userId = (String) request.getAttribute("userId");
				DetailEndUserExam  endUserDetailExam = (DetailEndUserExam) detailExam;
				examLikeService.processLikeStatus(userId, endUserDetailExam);
				examFavoriteService.processFavoriteStatus(userId, endUserDetailExam);
			}
			response.setResponseData(ResponseCode.SUCCESS, detailExam);
		}  catch (AbstractNihongoException e) {
			e.printStackTrace();
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PutMapping(value = API.EXAM.UPDATE_BY_ID)
	@ResponseBody
	public UpdateExamResponse update(@PathVariable String id, @RequestBody UpdateExamRequest request) {
		UpdateExamResponse response = new UpdateExamResponse();
		try {
			examService.udpate(id, request.getIsActive(), request.getIsFree(), 
									request.getIsTrial(), request.getPoint(), request.getCompletedMinutes());
		}  catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = API.EXAM.LIST)
	@ResponseBody
	public ListExamResponse listExam(@RequestBody ListExamRequest request) {
		ListExamResponse response = new ListExamResponse();
		try {
			SearchResult exams = examService.listExam(request.getLevel(),
															request.getExamType(), 
																request.getSkip(), 
																	request.getTake());
			examLikeService.processLikeStatus(request.getUserId(), exams.getDatas());
			response.setDatas(exams.getDatas());
		}  catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = API.EXAM.LIST_FAVORITE)
	@ResponseBody
	public ListExamResponse listFavariteExam(@RequestBody ListFavoriteExamRequest request) {
		ListExamResponse response = new ListExamResponse();
		try {
			SearchResult exams = examService.listFavoriteExam(request.getUserId(), request.getSkip(), request.getTake());
			examLikeService.processLikeStatus(request.getUserId(), exams.getDatas());
			response.setDatas(exams.getDatas());
		}  catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	} 
}
