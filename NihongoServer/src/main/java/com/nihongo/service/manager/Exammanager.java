package com.nihongo.service.manager;

import java.util.ArrayList;
import java.util.List;

import com.nihongo.data.entity.setting.ExamSetting;
import com.nihongo.data.entity.setting.TopicNumber;
import com.nihongo.support.constant.Constant;

/**
 * 
 * @author DoanhNV Aug 23, 2018 11:50:08 AM
 *
 */
public class Exammanager {

	public static ExamSetting getDefaultSetting(int level) {
		ExamSetting examSetting = new ExamSetting();
		switch (level) {
			case Constant.LEVEL.N5:
				examSetting = getN5Setting();
				break;
			case Constant.LEVEL.N4:
				examSetting = getN4Setting();
				break;
			case Constant.LEVEL.N3:
				examSetting = getN3Setting();
				break;
			case Constant.LEVEL.N2:
				examSetting = getN2Setting();
				break;
			case Constant.LEVEL.N1:
				examSetting = getN1Setting();
				break;
			default:	
		}
		return examSetting;
	}
	
	public static List<ExamSetting> listAllSetting() {
		List<ExamSetting> examSettings = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			examSettings.add(getDefaultSetting(i));
		}
		return examSettings;
	}
	
	public static ExamSetting getN5Setting() {
		ExamSetting examSetting = new ExamSetting(Constant.LEVEL.N5);
		List<TopicNumber> topicConfigs = new ArrayList<>();
		topicConfigs.add(new TopicNumber(Constant.TOPIC.HIRAGRANA_TO_KANJI, 12));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.KANJI_TO_HIRAGANA, 8));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.SYNONNYM, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_BRACES_1_VACABULARY, 10));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.REPLACE_STAR, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH, 1));
		examSetting.setTopicConfigs(topicConfigs);
		return examSetting;
	}
	
	public static ExamSetting getN4Setting() {
		ExamSetting examSetting = new ExamSetting(Constant.LEVEL.N4);
		List<TopicNumber> topicConfigs = new ArrayList<>();
		topicConfigs.add(new TopicNumber(Constant.TOPIC.HIRAGRANA_TO_KANJI, 9));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.KANJI_TO_HIRAGANA, 6));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.SYNONNYM, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_BRACES_1_VACABULARY, 15));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.WORDING, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_PARAGRAPH, 1));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH, 1));
		examSetting.setTopicConfigs(topicConfigs);
		return examSetting;
	}
	
	public static ExamSetting getN3Setting() {
		ExamSetting examSetting = new ExamSetting(Constant.LEVEL.N3);
		List<TopicNumber> topicConfigs = new ArrayList<>();
		topicConfigs.add(new TopicNumber(Constant.TOPIC.HIRAGRANA_TO_KANJI, 9));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.KANJI_TO_HIRAGANA, 6));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_BRACES_1_VACABULARY, 15));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.SYNONNYM, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_BRACES_2_STREAM_PARAGRAPH, 15));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.WORDING, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_PARAGRAPH, 1));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH, 1));
		examSetting.setTopicConfigs(topicConfigs);
		return examSetting;
	}
	
	public static ExamSetting getN2Setting() {
		ExamSetting examSetting = new ExamSetting(Constant.LEVEL.N2);
		List<TopicNumber> topicConfigs = new ArrayList<>();
		topicConfigs.add(new TopicNumber(Constant.TOPIC.HIRAGRANA_TO_KANJI, 9));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.KANJI_TO_HIRAGANA, 6));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_BRACES_1_VACABULARY, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_BRACES_2_STREAM_PARAGRAPH, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.SYNONNYM, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.WORDING, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_BRACES_3_GRAMMAR, 12));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.REPLACE_STAR, 5));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.FILL_INTO_PARAGRAPH, 1));
		topicConfigs.add(new TopicNumber(Constant.TOPIC.READING_UNDERSTANDING_PARAGRAPH, 1));
		examSetting.setTopicConfigs(topicConfigs);
		return examSetting;
	}
	
	public static ExamSetting getN1Setting() {
		ExamSetting examSetting = new ExamSetting(Constant.LEVEL.N1);
		List<TopicNumber> topicConfigs = new ArrayList<>();
		examSetting.setTopicConfigs(topicConfigs);
		return examSetting;
	}
}
