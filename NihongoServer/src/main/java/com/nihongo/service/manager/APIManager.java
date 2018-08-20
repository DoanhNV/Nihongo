package com.nihongo.service.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nihongo.filter.validation.DocumentValidationFilter;
import com.nihongo.filter.validation.ValidationFilter;
import com.nihongo.support.constant.API.DOCUMENT;
import com.nihongo.support.constant.API.FILE;
import com.nihongo.support.constant.API.MCQ_QUESTION;

/**
 * 
 * @author DoanhNV Aug 17, 2018 3:49:46 PM
 *
 */
public class APIManager {

	private static List<String> tokenAPIs = new ArrayList<>();
	private static Map<String, ValidationFilter> validateAPIMap = new HashMap<>();

	static {
		tokenAPIs.add(FILE.ROOT + FILE.UPLOAD_BASE64);
		tokenAPIs.add(FILE.ROOT + FILE.LOAD_BASE64);
		tokenAPIs.add(DOCUMENT.ROOT + DOCUMENT.CREATE);
		tokenAPIs.add(DOCUMENT.ROOT + DOCUMENT.GET_BY_ID);
		tokenAPIs.add(DOCUMENT.ROOT + DOCUMENT.SEARCH);
		tokenAPIs.add(DOCUMENT.ROOT + DOCUMENT.UPDATE);
		tokenAPIs.add(MCQ_QUESTION.ROOT + MCQ_QUESTION.ROOT);
		tokenAPIs.add(MCQ_QUESTION.ROOT + MCQ_QUESTION.SEARCH);
		tokenAPIs.add(MCQ_QUESTION.ROOT + MCQ_QUESTION.LIST);

		for (String uri : tokenAPIs) {
			if (uri.contains(DOCUMENT.ROOT)) {
				validateAPIMap.put(uri, new DocumentValidationFilter());
			}
		}
	}

	public static List<String> getTokenAPIs() {
		return tokenAPIs;
	}

	public static Map<String, ValidationFilter> getValidateAPIMap() {
		return validateAPIMap;
	}
	
	public static boolean isTokenAPI(String uri) {
		return tokenAPIs.contains(uri);
	}

	public static ValidationFilter getValidateFilter(String uri) {
		return validateAPIMap.get(uri);
	}
}
