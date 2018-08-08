package com.nihongo.dto.httpdto.response;

/**
 * 
 * @author DoanhNV Jul 29, 2018 10:41:16 PM
 */
public class AbstractSearchResponse extends AbstractResponse {
	
	protected int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
