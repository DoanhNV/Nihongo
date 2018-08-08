package com.nihongo.dto.httpdto.request;

import com.nihongo.data.entity.Sort;

/**
 * 
 * @author DoanhNV Aug 8, 2018 5:04:23 PM
 *
 */
public class DocumentSearchRequest extends AbstractSearchRequest {
	
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
