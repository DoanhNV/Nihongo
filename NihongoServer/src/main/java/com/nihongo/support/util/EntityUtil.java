package com.nihongo.support.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.AbstractSingleEntity;
import com.nihongo.data.entity.question.MCQQuestion;
import com.nihongo.dto.httpdto.request.AbstractRequest;

public class EntityUtil {
	
	public static void transferObjectTo(AbstractRequest sourceObject, AbstractEntity desObject) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(sourceObject, desObject);
	}
	
	public static void transferSingleObjectTo(AbstractRequest sourceObject, AbstractSingleEntity desObject) {
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
}
