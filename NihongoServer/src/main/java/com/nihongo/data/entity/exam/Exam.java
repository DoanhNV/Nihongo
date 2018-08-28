package com.nihongo.data.entity.exam;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Jul 7, 2018 3:07:28 PM
 */
public class Exam extends AbstractEntity {

	private int minutes;
	private boolean isTrial;
	private boolean free;
	private int likeNumber;
	private int createTime;
	private int lastUpdateTime;

	public Exam() {

	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public boolean isTrial() {
		return isTrial;
	}

	public void setTrial(boolean isTrial) {
		this.isTrial = isTrial;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(int lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
