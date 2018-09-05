package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Jul 29, 2018 9:56:59 PM
 */
public class AbstractSearchRequest extends AbstractNihongoRequest {

	protected int skip;
	protected int take;

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
