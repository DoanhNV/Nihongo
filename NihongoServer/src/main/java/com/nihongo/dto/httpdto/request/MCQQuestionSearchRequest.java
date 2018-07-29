package com.nihongo.dto.httpdto.request;

import com.nihongo.data.entity.Sort;

/**
 * 
 * @author DoanhNV Jul 9, 2018 9:12:25 AM
 */
public class MCQQuestionSearchRequest extends AbstractSearchRequest {

	private int topic;
	private int level;
	private Sort sort;

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getTake() {
		return take;
	}

	public void setTake(int take) {
		this.take = take;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
