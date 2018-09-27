package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Sep 27, 2018 - 10:55:30 PM
 *
 */
public class ListFavoriteExamRequest extends AbstractNihongoRequest {

	private String userId;
	private int skip;
	private int take;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getTake() {
		return take;
	}

	public void setTake(int take) {
		this.take = take;
	}
}
