package com.nihongo.dto.httpdto.entity;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 10:11:34 PM
 *
 */
public class DetailEndUserExam extends DetailExam {
	
	private boolean isFavrited;
	
	public boolean getIsFavrited() {
		return isFavrited;
	}

	public void setFavrited(boolean isFavrited) {
		this.isFavrited = isFavrited;
	}
}
