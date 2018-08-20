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
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.AbstractNihongoRequest;

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
	
	public static AbstractEntity mappingJsonStringToObject(String jsonString, Class<AbstractEntity> className) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		return mapper.readValue(jsonString, className);
	}
}
