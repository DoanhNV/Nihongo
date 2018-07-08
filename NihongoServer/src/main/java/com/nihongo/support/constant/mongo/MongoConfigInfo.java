package com.nihongo.support.constant.mongo;

/**
 * 
 * @author DoanhNV
 * Jul 7, 2018 8:55:58 PM
 */
public class MongoConfigInfo {
	public static final String HOST = "localhost";
	public static final int PORT = 27017;
	
	public static final String EXAM_DB = "exam";
	
	public class EXAM_DB {
		
		public static final String MCQ_QUESTION_COLLECTION = "mcq_question";
		public static final String DOCUMENT_COLLECTION = "question_document";
	}
}