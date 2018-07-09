package com.nihongo.support.util;

import org.modelmapper.ModelMapper;

import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.data.entity.AbstractSingleEntity;
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
}
