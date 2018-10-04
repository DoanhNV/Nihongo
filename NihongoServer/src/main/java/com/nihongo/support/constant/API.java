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
	
	public class EXAM {
		public static final String ROOT = "/exam";
		public static final String CREATE_RANDOM_EXAM =  "/create/random";
		public static final String GET_RANDOM_EXAM = "/get/random/{level}";
		public static final String SEARCH = "/search";
		public static final String DETAIL = "detail/{id}/{clientQueryMode}";
		public static final String DETAIL_ALIAS = "detail/";
		public static final String UPDATE_BY_ID = "/update/{id}";
		public static final String LIST = "/list";
	}
	
	
	public class USER {
		public static final String ROOT = "/user";
		public static final String REGISTER =  "/register";
		public static final String LOGIN = "/login";
	}
	
	public class USER_CONNECTION {
		public static final String ROOT = USER.ROOT;
		public static final String LIKE =  "/like";
		public static final String FAVORITE = "/favorite";
	}
}
