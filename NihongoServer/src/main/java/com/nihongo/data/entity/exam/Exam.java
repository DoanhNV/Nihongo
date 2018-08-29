package com.nihongo.data.entity.exam;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Jul 7, 2018 3:07:28 PM
 */
public class Exam extends AbstractEntity {
	
	private int level;
	private int completedMinutes;
	private boolean isTrial;
	private boolean isFree;
	private int likeNumber;
	private long createTime;
	private long updateTime;
	private List<EmbedExamTopic> embedExamTopics;

	public Exam() {
		init();
	}

	public void init() {
		long currentServerTime = System.currentTimeMillis();
		this.setCreateTime(currentServerTime);
		this.setUpdateTime(currentServerTime);
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

	public int getCompletedMinutes() {
		return completedMinutes;
	}

	public void setCompletedMinutes(int completedMinutes) {
		this.completedMinutes = completedMinutes;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public List<EmbedExamTopic> getEmbedExamTopics() {
		return embedExamTopics;
	}

	public void setEmbedExamTopics(List<EmbedExamTopic> embedExamTopics) {
		this.embedExamTopics = embedExamTopics;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
