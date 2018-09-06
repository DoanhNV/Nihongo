package com.nihongo.support.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.AbstractSingleEntity;
import com.nihongo.data.entity.exam.Exam;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.AbstractDTO;
import com.nihongo.dto.httpdto.entity.BasicExam;
import com.nihongo.dto.httpdto.entity.DetailBackendExam;
import com.nihongo.dto.httpdto.entity.DetailEndUserExam;
import com.nihongo.dto.httpdto.entity.DetailExam;
import com.nihongo.dto.httpdto.request.AbstractNihongoRequest;
import com.nihongo.support.constant.Constant;

public class EntityUtil {
	
	public static void transferObjectTo(AbstractNihongoRequest sourceObject, AbstractEntity desObject) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(sourceObject, desObject);
	}
	
	public static void transferSingleObjectTo(AbstractNihongoRequest sourceObject, AbstractSingleEntity desObject) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(sourceObject, desObject);
	}
	
	public static List<MCQQuestion> castToMCQQuestionObject(List<AbstractEntity> entitys) {
		List<MCQQuestion> questions = new ArrayList<>();
		if(entitys != null && !entitys.isEmpty()) {
			for (AbstractEntity entity : entitys) {
				MCQQuestion question = (MCQQuestion) entity;
				questions.add(question);
			}
 		}
		return questions;
	}
	
	public static List<Document> castToDocumentObject(List<AbstractEntity> entitys) {
		List<Document> documents = new ArrayList<>();
		if(entitys != null && !entitys.isEmpty()) {
			for (AbstractEntity entity : entitys) {
				Document document = (Document) entity;
				documents.add(document);
			}
		}
		return documents;
	}
	
	public static List<BasicExam> castBasicExamObject(List<AbstractDTO> entitys) {
		List<BasicExam> documents = new ArrayList<>();
		if(entitys != null && !entitys.isEmpty()) {
			for (AbstractDTO entity :  entitys) {
				BasicExam document = (BasicExam) entity;
				documents.add(document);
			}
		}
		return documents;
	}
	
	public static AbstractEntity mappingJsonStringToObject(String jsonString, Class<AbstractEntity> className) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		return mapper.readValue(jsonString, className);
	}
	
	public static DetailExam toDetailExam(Exam exam,Integer clientQueryMode) {
		boolean isBackendQuery = clientQueryMode == Constant.CLIENT_QUERY_MODE.BACKEND_MODE;
		DetailExam detailExam = isBackendQuery ? new DetailBackendExam() : new DetailEndUserExam();
		detailExam.setId(exam.getId());
		detailExam.setLevel(exam.getLevel());
		detailExam.setLikeNumber(exam.getLikeNumber());
		detailExam.setTakedNumber(exam.getTakedNumber());
		detailExam.setCompletedMinutes(exam.getCompletedMinutes());
		detailExam.setPoint(exam.getPoint());
		detailExam.setFree(exam.isFree());
		detailExam.setTrial(exam.isTrial());
		detailExam.setUpdateTime(exam.getUpdateTime());
		
		if(isBackendQuery) {
			DetailBackendExam detailBackendExam = (DetailBackendExam) detailExam;
			detailBackendExam.setActive(exam.isActive());
			detailBackendExam.setCreateTime(exam.getCreateTime());
			detailExam = detailBackendExam;
		}
		return detailExam;
	}
}
