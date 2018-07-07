package com.nihongo.support.util;

import org.modelmapper.ModelMapper;

import com.nihongo.data.entity.AbstractEntity;
import com.nihongo.httpdto.request.AbstractRequest;

public class EntityUtil {
	
	public static AbstractEntity transferObjectTo(AbstractRequest sourceObject, AbstractEntity desObject) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(sourceObject, desObject);
		return desObject;
	}
}
