package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Nov 4, 2018 - 12:50:45 PM
 *
 */
public class DeleteDocumentRequest extends AbstractNihongoRequest{
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
