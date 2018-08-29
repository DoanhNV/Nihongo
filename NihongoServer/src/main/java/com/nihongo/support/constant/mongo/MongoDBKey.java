package com.nihongo.support.constant.mongo;

/**
 * 
 * @author DoanhNV Jul 7, 2018 9:12:02 PM
 */
public class MongoDBKey {
	
	public static final String ID = "_id";
	public static final String TOPIC = "topic";
	public static final String LEVEL = "level";
	public static final String CONTENT = "content";
	public static final String TYPE = "type";
	public static final String SUB_TITLE = "sub_title";
	public static final String DOCUMENT = "document";
	public static final String QUESTION_IDS = "question_ids";
	
	public class MCQQuestionKey extends MongoDBKey {
		public static final String TITLE = "title";
		public static final String ANSWERS = "answers";
		public static final String IS_CORRECT = "is_correct";
	}
	
	public class DocumentKey extends MongoDBKey {
		
	}
	
	public class ExamKey extends MongoDBKey {
		public static final String EXAM_NAME = "exam_name";
		public static final String IS_TRIAL = "is_trial";
		public static final String IS_FREE = "is_free";
		public static final String LIKE_NUMBER = "like_number";
		public static final String CREATE_TIME = "create_time";
		public static final String UPDATE_TIME = "update_time";
		public static final String EMBED_TOPIC = "embed_topic";
	}
	
	public class SETTING extends MongoDBKey {
		public static final String NUMBER = "number";
		public static final String TOPIC_CONFIGS = "topic_configs";
	} 
}
