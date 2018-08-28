package com.nihongo.controller.function;

import static com.nihongo.support.constant.Constant.MAX_TOPIC_PER_EXAM;
import static com.nihongo.support.constant.Constant.MAX_TOPIC_NUMBER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.dto.httpdto.RandomExamDTO;
import com.nihongo.dto.httpdto.request.RandomCreateExamRequest;
import com.nihongo.dto.httpdto.response.RandomCreateExamResponse;
import com.nihongo.dto.httpdto.response.RandomExamResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.ExamService;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.support.util.NihongoUtil;

/**
 * 
 * @author DoanhNV Jul 9, 2018 10:18:09 AM
 */
@RequestMapping(value = "/exam")
@RestController
@CrossOrigin
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@GetMapping(value = "/get/random/{level}")
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
	
	@PostMapping(value = "/create/random")
	@ResponseBody
	public RandomCreateExamResponse createRandom(@RequestBody RandomCreateExamRequest request) {
		RandomCreateExamResponse response = new RandomCreateExamResponse();
		try {
			
		}  catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		}  catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
}
