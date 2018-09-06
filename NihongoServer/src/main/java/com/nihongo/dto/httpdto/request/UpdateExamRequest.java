package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Sep 4, 2018 - 10:15:53 PM
 *
 */
public class UpdateExamRequest extends AbstractNihongoRequest {

	private Boolean isFree;
	private Boolean isTrial;
	private Boolean isActive;
	private Integer point;
	private Integer completedMinutes;

	public Boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}

	public Boolean getIsTrial() {
		return isTrial;
	}

	public void setIsTrial(Boolean isTrial) {
		this.isTrial = isTrial;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getCompletedMinutes() {
		return completedMinutes;
	}

	public void setCompletedMinutes(Integer completedMinutes) {
		this.completedMinutes = completedMinutes;
	}
}
