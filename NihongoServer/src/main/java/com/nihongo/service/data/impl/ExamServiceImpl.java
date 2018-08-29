package com.nihongo.service.data.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.dao.ExamDAO;
import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.dao.SettingDAO;
import com.nihongo.data.entity.exam.EmbedExamTopic;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.question.Question;
import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.data.entity.setting.TopicNumber;
import com.nihongo.dto.httpdto.entity.RandomExamDTO;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.ExamService;
import com.nihongo.support.constant.Constant;

/**
 * 
 * @author DoanhNV Jul 9, 2018 11:10:27 AM
 */
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private MCQQuestionDAO mcqQuestionDAO;
	@Autowired
	private SettingDAO settingDAO;
	@Autowired
	private ExamDAO examDAO;
	@Autowired
	private DocumentDAO documentDAO;
	
	@Override
	public List<RandomExamDTO> getRandomExam(int level, List<Integer> topics) {
		List<RandomExamDTO> exams = new ArrayList<>();
		Map<Integer, List<Question>> examMap = mcqQuestionDAO.getRandomExam(level, topics);
		for (Entry<Integer, List<Question>> entry : examMap.entrySet()) {
			RandomExamDTO randomExamDTO = new RandomExamDTO(entry.getKey(), entry.getValue());
			exams.add(randomExamDTO);
		}
		return exams;
	}

	@Override
	public boolean createRandomExam(int level) {
		ExamSetting examSetting = settingDAO.getExamSetting(level);
		Exam exam = new Exam();
		List<EmbedExamTopic> embedExamTopics = new ArrayList<>();
		if(examSetting == null) {
			throw new AbstractNihongoException();
		}
		
		for (TopicNumber topicNumber : examSetting .getTopicConfigs()) {
			int topic = topicNumber.getTopic();
			List<String> questionIds = new ArrayList<>();
			boolean isParagraph = topic == Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH  
											|| topic == Constant.TOPIC.FILL_INTO_PARAGRAPH;
			if(isParagraph) {
				questionIds = documentDAO.getRandomQuestions(topic, level, topicNumber.getNumber());
			} else {
				questionIds = mcqQuestionDAO.getRandomQuestions(topic, level, topicNumber.getNumber());
			}
			EmbedExamTopic examTopic = new EmbedExamTopic(topic, questionIds);
			embedExamTopics.add(examTopic);
		}
		exam.setEmbedExamTopics(embedExamTopics);
		return examDAO.insert(exam);
	}

	@Override
	public SearchData search(SearchExamRequest request) {
		return examDAO.search(request);
	}
}
