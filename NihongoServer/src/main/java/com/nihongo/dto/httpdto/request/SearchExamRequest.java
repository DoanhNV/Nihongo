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
	private boolean isTrial;
	private boolean isFree;
	private int fromCompletedMinutes;
	private int toCompletedMinutes;
	private long fromCreateTime;
	private long toCreateTime;
	private long fromUpdateTime;
	private long toUpdateTime;

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

	public boolean isTrial() {
		return isTrial;
	}

	public void setIsTrial(boolean isTrial) {
		this.isTrial = isTrial;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getFromCompletedMinutes() {
		return fromCompletedMinutes;
	}

	public void setFromCompletedMinutes(int fromCompletedMinutes) {
		this.fromCompletedMinutes = fromCompletedMinutes;
	}

	public int getToCompletedMinutes() {
		return toCompletedMinutes;
	}

	public void setToCompletedMinutes(int toCompletedMinutes) {
		this.toCompletedMinutes = toCompletedMinutes;
	}

	public long getFromCreateTime() {
		return fromCreateTime;
	}

	public void setFromCreateTime(long fromCreateTime) {
		this.fromCreateTime = fromCreateTime;
	}

	public long getToCreateTime() {
		return toCreateTime;
	}

	public void setToCreateTime(long toCreateTime) {
		this.toCreateTime = toCreateTime;
	}

	public long getFromUpdateTime() {
		return fromUpdateTime;
	}

	public void setFromUpdateTime(long fromUpdateTime) {
		this.fromUpdateTime = fromUpdateTime;
	}

	public long getToUpdateTime() {
		return toUpdateTime;
	}

	public void setToUpdateTime(long toUpdateTime) {
		this.toUpdateTime = toUpdateTime;
	}
}
