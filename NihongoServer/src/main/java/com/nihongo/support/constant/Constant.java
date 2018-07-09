package com.nihongo.support.constant;

/**
 * 
 * @author DoanhNV
 * Jul 7, 2018 10:33:47 AM
 */
public class Constant {
	public static final int TOPIC_NUMBER = 7;
	public static final int MAX_TOPIC_PER_EXAM = 4;
	
	public class TOPIC {
		public static final int HIRAGRANA_TO_KANJI = 0;
		public static final int KANJI_TO_HIRAGANA = 1;
		public static final int VOCABULARY = 2;
		public static final int SYNONNYM = 3;
		public static final int FILL_INTO_BRACES = 4;
		public static final int REPLACE_START = 5;
		public static final int READING_UNDERSTANDING = 6;
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
		public static final String DEFAULT_IMAGE_DIRECTORY = "d:/";
		public static final String DEFAULT_IMAGE_EXTENTION = ".png";
		public static final String DEFAULT_VIDEO_DIRECTORY = "d:/";
		public static final String DEFAULT_VIDEO_EXTENTION = ".mp4";
		public static final int IMAGE_TYPE = 0;
		public static final int VIDEO_TYPE = 1;
	}
}
