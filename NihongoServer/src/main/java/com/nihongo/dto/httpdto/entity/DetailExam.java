package com.nihongo.dto.httpdto.entity;

import java.util.List;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 9:36:11 PM
 *
 */
public class DetailExam {

	protected String id;
	private int point;
	protected int level;
	protected int likeNumber;
	protected int takedNumber;
	protected int completedMinutes;
	protected long updateTime;
	protected boolean isFree;
	protected boolean isTrial;
	protected List<ExamDTO> contents;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public int getTakedNumber() {
		return takedNumber;
	}

	public void setTakedNumber(int takedNumber) {
		this.takedNumber = takedNumber;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean getIsTrial() {
		return isTrial;
	}

	public void setTrial(boolean isTrial) {
		this.isTrial = isTrial;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public List<ExamDTO> getContents() {
		return contents;
	}

	public void setContents(List<ExamDTO> contents) {
		this.contents = contents;
	}

	public int getCompletedMinutes() {
		return completedMinutes;
	}

	public void setCompletedMinutes(int completedMinutes) {
		this.completedMinutes = completedMinutes;
	}
}
