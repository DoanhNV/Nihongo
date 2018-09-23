package com.nihongo.support.constant;

/**
 * 
 * @author DoanhNV Jul 26, 2018 4:35:21 PM
 *
 */
public class ResponseCode {
	
	/**
	 * System code
	 */
	public static final float SUCCESS = 1.1f;
	public static final float SYSTEM_ERROR = 1.2f;
	
	/**
	 * Param code
	 */
	public static final float INVALID_ID = 2.1f;
	public static final float INVALID_TOKEN = 2.2f;
	public static final float EXPIRED_TOKEN = 2.3f;
	public static final float EXISTED_USER_NAME = 2.4f;
	public static final float USER_NOT_EXIST = 2.5f;
	
	
	/**
	 * File code
	 */
	public static final float UPLOAD_FAIL = 3.1f;
	public static final float FILE_NOT_EXIST = 3.2f;
	
	/**
	 * Exam
	 */
	public static final float LEVEL_NOT_SETTING = 4.1f;
	public static final float NOT_ENOUGH_QUESTION_PER_TOPIC = 4.2f;
	public static final float EXAM_NOT_EXIST= 4.3f;
}
