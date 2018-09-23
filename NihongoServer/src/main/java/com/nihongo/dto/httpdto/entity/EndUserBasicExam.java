package com.nihongo.dto.httpdto.entity;

import com.nihongo.dto.httpdto.AbstractDTO;

/**
 * 
 * @author DoanhNV Sep 22, 2018 - 5:29:07 PM
 *
 */
public class EndUserBasicExam  extends AbstractDTO{

	private String id;
	private int level;
	private int takedNumber;
	private int likeNumber;
	private boolean isFree;

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

	public int getTakedNumber() {
		return takedNumber;
	}

	public void setTakedNumber(int takedNumber) {
		this.takedNumber = takedNumber;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
}
