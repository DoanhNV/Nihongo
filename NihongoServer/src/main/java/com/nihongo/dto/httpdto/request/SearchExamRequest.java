package com.nihongo.dto.httpdto.request;

import com.nihongo.data.entity.Sort;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 10:21:44 PM
 *
 */
public class SearchExamRequest extends AbstractSearchRequest {
	
	private int level;
	private Sort sort;
	private Boolean isTrial;
	private Boolean isFree;

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

	public Boolean getIsTrial() {
		return isTrial;
	}

	public void setIsTrial(Boolean isTrial) {
		this.isTrial = isTrial;
	}

	public Boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}
}
