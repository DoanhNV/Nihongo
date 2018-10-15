package com.nihongo.service.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.DocumentDAO;
import com.nihongo.data.dao.ExamDAO;
import com.nihongo.data.dao.ExamFavoriteDAO;
import com.nihongo.data.dao.MCQQuestionDAO;
import com.nihongo.data.dao.SettingDAO;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.exam.EmbedExamTopic;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.data.entity.other.transfer.SearchResult;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.data.entity.question.Question;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.data.entity.setting.TopicNumber;
import com.nihongo.dto.httpdto.entity.DetailEndUserExamQuestion;
import com.nihongo.dto.httpdto.entity.DetailExam;
import com.nihongo.dto.httpdto.entity.ExamDTO;
import com.nihongo.dto.httpdto.entity.ExamElement;
import com.nihongo.dto.httpdto.entity.RandomExamDTO;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.ExamService;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.support.util.EntityUtil;
import com.nihongo.support.util.TransferData.DetailExamTransfer;

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
	@Autowired
	private ExamFavoriteDAO examFavoriteDAO;
	
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
		List<TopicNumber> topicConfigs = examSetting.getTopicConfigs();
		Exam exam = new Exam(level);
		List<EmbedExamTopic> embedExamTopics = new ArrayList<>();
		if(examSetting == null || topicConfigs == null || topicConfigs.isEmpty()) {
			throw new AbstractNihongoException(ResponseCode.LEVEL_NOT_SETTING);
		}
		
		for (TopicNumber topicNumber : topicConfigs) {
			int topic = topicNumber.getTopic();
			List<String> questionIds = new ArrayList<>();
			boolean isParagraph = topic == Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH  
											|| topic == Constant.TOPIC.FILL_INTO_PARAGRAPH;
			if(isParagraph) {
				questionIds = documentDAO.getRandomQuestions(topic, level, topicNumber.getNumber());
			} else {
				questionIds = mcqQuestionDAO.getRandomQuestions(topic, level, topicNumber.getNumber());
			}
			
			if(questionIds.size() < topicNumber.getNumber()) {
				throw new AbstractNihongoException(ResponseCode.NOT_ENOUGH_QUESTION_PER_TOPIC);
			}
			EmbedExamTopic examTopic = new EmbedExamTopic(topic, questionIds);
			embedExamTopics.add(examTopic);
		}
		
		exam.setEmbedExamTopics(embedExamTopics);
		return examDAO.insert(exam);
	}
	
	@Override
	public DetailExam getDetail(String id, int clientQueryMode) {
		Exam exam = examDAO.getExam(id, clientQueryMode);
		if(exam == null) {
			throw new AbstractNihongoException(ResponseCode.EXAM_NOT_EXIST);
		}
		
		DetailExam detailExam = EntityUtil.toDetailExam(exam, clientQueryMode);
		List<EmbedExamTopic> embedExamTopics = exam.getEmbedExamTopics();
		List<String> questionIds = new ArrayList<>();
		Map<Integer, Document> documentMap = new HashMap<>();
		List<Integer> topics = new ArrayList<>();
		
		for (EmbedExamTopic embedExamTopic : embedExamTopics) {
			int topic = embedExamTopic.getTopic();
			topics.add(topic);
			boolean isParagraph = topic == Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH  
														|| topic == Constant.TOPIC.FILL_INTO_PARAGRAPH;
			if (isParagraph) {
				String paragraphId = embedExamTopic.getMcqQuestionIds().get(0);
				Document document = (Document) documentDAO.getById(paragraphId);
				documentMap.put(topic, document);
				questionIds.addAll(document.getQuestionIds());
			} else {
				questionIds.addAll(embedExamTopic.getMcqQuestionIds());
			}
		}
		
		List<AbstractEntity> questionList = mcqQuestionDAO.listByIds(questionIds).getDatas();
		List<MCQQuestion> mcqQuestions = EntityUtil.castToMCQQuestionObject(questionList);
		
		DetailExamTransfer  detailExamTransfer = new DetailExamTransfer(topics);
		Map<Integer, List<ExamElement>> topicMap = detailExamTransfer.getTopicMap();

		for (MCQQuestion mcqQuestion : mcqQuestions) {
			int topic = mcqQuestion.getTopic();
			List<ExamElement> examTopicElements = topicMap.get(topic);
			ExamElement examElement = (DetailEndUserExamQuestion) new DetailEndUserExamQuestion(
													mcqQuestion.getTitle(), 
													mcqQuestion.getDocument(),
													mcqQuestion.getAnswers(), 
													mcqQuestion.getTitleSub());
			examTopicElements.add(examElement);
		}
		
		List<ExamDTO> contents = new ArrayList<>();
		for (Entry<Integer, List<ExamElement>> entry : topicMap.entrySet()) {
			Integer topic = entry.getKey();
			Document document = documentMap.get(topic);
			String content = document == null ? null : document.getContent();
			contents.add(new ExamDTO(entry.getKey(), entry.getValue(), content));
		}
		detailExam.setContents(contents);
		return  detailExam;
	}

	@Override
	public boolean udpate(String id, Boolean isActive, Boolean isFree, Boolean isTrial, Integer point, Integer completedMinutes) {
		return examDAO.update(id, isActive, isFree, isTrial, point, completedMinutes);
	}
	
	@Override
	public SearchResult search(SearchExamRequest request) {
		return examDAO.search(request);
	}

	@Override
	public SearchResult listExam(Integer level, Integer examType, int skip, int take) {
		return examDAO.listExam(level, examType, skip, take);
	}
	
	@Override
	public SearchResult listFavoriteExam(String userId, int skip, int take) {
		List<String> favoriteExamIds = examFavoriteDAO.listFavoriteExam(userId, skip, take);
		SearchResult favoritesExamResult = examDAO.listFavoriteExam(favoriteExamIds);
		return favoritesExamResult;
	}

	@Override
	public void changeLikeNumber(String examId, boolean isLikedBefore) {
		if (isLikedBefore) {
			examDAO.decreaseLikeNumber(examId);
		} else {
			examDAO.encreaseLikeNumber(examId);
		}
	}
}
