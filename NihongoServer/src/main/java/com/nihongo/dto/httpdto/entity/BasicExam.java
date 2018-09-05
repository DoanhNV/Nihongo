package com.nihongo.dto.httpdto.entity;

import com.nihongo.dto.httpdto.AbstractDTO;

/**
 * 
 * @author DoanhNV Aug 29, 2018 - 9:16:25 PM
 *
 */
public class BasicExam extends AbstractDTO {

	private String id;
	private int completedMinutes;
	private long createTime;
	private long updateTime;
	private boolean isTrial;
	private boolean isFree;
	private boolean isActive;
	private int level;
	private int point;
	private int likeNumber;
	private int takedNumber;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public boolean getIsTrial() {
		return isTrial;
	}

	public void setTrial(boolean isTrial) {
		this.isTrial = isTrial;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getTakedNumber() {
		return takedNumber;
	}

	public void setTakedNumber(int takedNumber) {
		this.takedNumber = takedNumber;
	}
	
	public void setCompletedMinutes(int completedMinutes) {
		this.completedMinutes = completedMinutes;
	}
	
	public int getCompletedMinutes() {
		return completedMinutes;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
