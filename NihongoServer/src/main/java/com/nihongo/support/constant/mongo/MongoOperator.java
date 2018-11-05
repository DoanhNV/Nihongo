package com.nihongo.support.constant.mongo;

/**
 * 
 * @author DoanhNV
 * Jul 7, 2018 10:33:43 AM
 */
public class MongoOperator {
	
	public static final String $IN = "$in";
	public static final String NOT_IN = "$nin";
	public static final String $SET = "$set";
	public static final String $SAMPLE = "$sample";
	public static final String $MATCH = "$match";
	public static final String $PROJECT = "$project";
	public static final String OR = "$or";
	public static final String PUSH = "$push";
	public static final String ADD_TO_SET = "$addToSet";
	public static final String PULL = "$pull";
	public static final String INCREASE = "$inc";
	public static final String ELEMENT_MATCH = "$elemMatch";
	
	public static final String SIZE = "size";
	
	public static final int INCLUDE_FIELD  = 1;
}
