package com.nihongo.support.constant.mongo;

/**
 * 
 * @author DoanhNV Jul 7, 2018 9:12:02 PM
 */
public class MongoDBKey {
	public static final String ID = "_id";
	public static final String TOPIC = "topic";
	public static final String LEVEL = "level";
	
	public class MCQQuestionKey extends MongoDBKey {
		public static final String TITLE = "title";
		public static final String ANSWERS = "answers";
		public static final String CONTENT = "content";
		public static final String IS_CORRECT = "is_correct";
	}
	
}
