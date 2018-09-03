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
import com.nihongo.dto.httpdto.entity.DetailEndUserDocument;
import com.nihongo.dto.httpdto.entity.DetailExam;
import com.nihongo.dto.httpdto.entity.ExamDTO;
import com.nihongo.dto.httpdto.entity.ExamElement;
import com.nihongo.dto.httpdto.entity.RandomExamDTO;
import com.nihongo.dto.httpdto.request.SearchExamRequest;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.ExamService;
import com.nihongo.support.constant.Constant;
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
	public DetailExam getDetail(String id, int clientQueryMode) {
		DetailExam detailExam = new DetailExam();
		Exam exam = examDAO.getExam(id, clientQueryMode);
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
			ExamElement examElement = null;
			
			boolean isParagraph = topic == Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH  
														|| topic == Constant.TOPIC.FILL_INTO_PARAGRAPH;
			
			List<ExamElement> examTopicElements = topicMap.get(topic);
			if (isParagraph) {
				DetailEndUserDocument detailDocument = null;
				if(examTopicElements.size() == 0) {
					detailDocument = new DetailEndUserDocument();
					detailDocument.setQuestions(new ArrayList<MCQQuestion>());
					detailDocument.setTopic(topic);
					detailDocument.setContent(documentMap.get(topic).getContent());
					examElement = detailDocument;
					examTopicElements.add(examElement);
				} else {
					detailDocument = (DetailEndUserDocument) examTopicElements.get(0);
				}

				detailDocument.getQuestions().add(mcqQuestion);
			} else {
				examElement = mcqQuestion;
				examTopicElements.add(examElement);
			}
		}
		
		List<ExamDTO> contents = new ArrayList<>();
		for (Entry<Integer, List<ExamElement>> entry : topicMap.entrySet()) {
			contents.add(new ExamDTO(entry.getKey(), entry.getValue()));
		}
		detailExam.setContents(contents);
		return  detailExam;
	}

	@Override
	public SearchResult search(SearchExamRequest request) {
		return examDAO.search(request);
	}
}
