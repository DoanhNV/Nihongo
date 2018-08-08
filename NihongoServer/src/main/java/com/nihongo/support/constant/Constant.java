package com.nihongo.support.constant;

/**
 * 
 * @author DoanhNV
 * Jul 7, 2018 10:33:47 AM
 */
public class Constant {

	public static final int TOPIC_NUMBER = 7;
	public static final int MAX_TOPIC_PER_EXAM = 4;
	public static final int MAX_TOPIC_NUMBER = 7;
	
	
	public class TOPIC {
		public static final int HIRAGRANA_TO_KANJI = 0;
		public static final int KANJI_TO_HIRAGANA = 1;
		public static final int FILL_INTO_BRACES_1_VACABULARY = 2;
		public static final int SYNONNYM = 3;
		public static final int FILL_INTO_BRACES_2_STREAM_PARAGRAPH = 4;
		public static final int REPLACE_STAR = 5;
		public static final int READING_UNDERSTANDING = 6;
		public static final int LISTEN_AND_ANSWER = 7;
		public static final int FILL_INTO_BRACES_3_GRAMMAR = 8;
		public static final int WORDING = 9;
		public static final int READING_UNDERSTANDING_PARAGRAPH = 10;
		public static final int FILL_INTO_PARAGRAPH = 11;
	}
	
	public class LEVEL {
		public static final int BEGINER = 0;
		public static final int N1 = 1;
		public static final int N2 = 1;
		public static final int N3 = 1;
		public static final int N4 = 1;
		public static final int N5 = 1;
	}
	
	public class FILE {
		public static final String DEFAULT_IMAGE_DIRECTORY = "/opt/image/";
		public static final String DEFAULT_IMAGE_EXTENTION = ".png";
		public static final String DEFAULT_VIDEO_DIRECTORY = "/opt/image/";
		public static final String DEFAULT_VIDEO_EXTENTION = ".mp4";
		public static final int IMAGE_TYPE = 0;
		public static final int VIDEO_TYPE = 1;
		public static final String BASE64_PREFIX = "data:image/png;base64,";
	}
	
	public class PROPERTIES {
		public static final int QUERY_ALL = -1;
		public static final int DEFAULT_SORT_VALUE = -1;
		public static final String DEFAULT_SORT_FIELD = "_id";
	}
	
	public class ENCODING {
		public static final String UTF_8 = "UTF-8";
	}
	
	public class STRING_PROPERTIES {
		public static final String EMPTY = "";
	}
}
