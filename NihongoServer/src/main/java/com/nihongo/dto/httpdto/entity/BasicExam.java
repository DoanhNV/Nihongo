package com.nihongo.dto.httpdto.entity;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 9:16:25 PM
 *
 */
public class BasicExam extends RandomExamDTO {

	private int completedMinutes;
	private boolean isTrial;
	private boolean isFree;
	private int likeNumber;
	private long createTime;
	private long updateTime;

	public int getCompletedMinutes() {
		return completedMinutes;
	}

	public void setCompletedMinutes(int completedMinutes) {
		this.completedMinutes = completedMinutes;
	}

	public boolean isTrial() {
		return isTrial;
	}

	public void setTrial(boolean isTrial) {
		this.isTrial = isTrial;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
}
