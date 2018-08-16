package com.nihongo.dto.httpdto.response;

/**
 * 
 * @author DoanhNV Aug 8, 2018 11:36:39 AM
 *
 */
public abstract class AbstractInsertResponse extends NihongoResponse {

	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
