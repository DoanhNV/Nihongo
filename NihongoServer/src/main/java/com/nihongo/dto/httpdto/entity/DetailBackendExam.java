package com.nihongo.dto.httpdto.entity;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 9:44:08 PM
 *
 */
public class DetailBackendExam extends DetailExam {

	private boolean isActive;
	private long createTime;

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
