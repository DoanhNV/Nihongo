package com.nihongo.support.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author DoanhNV Aug 17, 2018 3:49:46 PM
 *
 */
public class API {
	
	public static List<String> tokenAPI = new ArrayList<>();
	
	 static {
		tokenAPI.add(FILE.ROOT + FILE.UPLOAD_BASE64);
		tokenAPI.add(FILE.ROOT + FILE.LOAD_BASE64);
		tokenAPI.add(DOCUMENT.ROOT + DOCUMENT.CREATE);
		tokenAPI.add(DOCUMENT.ROOT + DOCUMENT.GET_BY_ID);
		tokenAPI.add(DOCUMENT.ROOT + DOCUMENT.SEARCH);
		tokenAPI.add(DOCUMENT.ROOT + DOCUMENT.UPDATE);
		tokenAPI.add(MCQ_QUESTION.ROOT + MCQ_QUESTION.ROOT);
		tokenAPI.add(MCQ_QUESTION.ROOT + MCQ_QUESTION.SEARCH);
		tokenAPI.add(MCQ_QUESTION.ROOT + MCQ_QUESTION.LIST);
	}
	
	public class FILE {
		public static final String ROOT = "/file";
		public static final String UPLOAD_BASE64 = "/upload/base64";
		public static final String LOAD_BASE64 = "/load/base64";
	}
	
	public class DOCUMENT {
		public static final String ROOT = "/document";
		public static final String CREATE = "/create";
		public static final String GET_BY_ID = "/get/{id}";
		public static final String SEARCH = "/search";
		public static final String UPDATE = "/update";
	}
	
	public class MCQ_QUESTION {
		public static final String ROOT = "/mvcquestion";
		public static final String CREATE = "/create";
		public static final String SEARCH = "/search";
		public static final String LIST = "/list";
	}
}
