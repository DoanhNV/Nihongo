package com.nihongo.support.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nihongo.data.entity.question.Question;

/**
 * 
 * @author DoanhNV Jul 9, 2018 10:55:28 AM
 */
public class TransferData {

	public static class RandomExamTransfer {

		private Map<Integer, List<Question>> topicMap = new HashMap<>();

		public RandomExamTransfer(List<Integer> topics) {
			for (int i = 0; i < topics.size(); i++) {
				List<Question> questions = new ArrayList<>();
				topicMap.put(topics.get(i), questions);
			}
		}

		public Map<Integer, List<Question>> getTopicMap() {
			return topicMap;
		}

		public void setTopicMap(Map<Integer, List<Question>> topicMap) {
			this.topicMap = topicMap;
		}
	}
}
