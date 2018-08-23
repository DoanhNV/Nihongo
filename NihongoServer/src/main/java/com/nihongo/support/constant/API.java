package com.nihongo.support.constant;

/**
 * 
 * @author DoanhNV Aug 21, 2018 12:08:26 AM
 */
public class API {

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
	
	public class SETTING {
		public static final String ROOT = "/setting";
		public static final String SET_EXAM_NUMBER = "/exam/set/number";
		public static final String LIST_EXAM_SETTING = "/exam/list";
	}
}
