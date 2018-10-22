package com.nihongo.dto.httpdto.response;

import com.nihongo.dto.httpdto.entity.BasicLoginUser;

/**
 * 
 * @author DoanhNV Oct 20, 2018 - 4:33:54 PM
 *
 */
public class GetUserInfoResponse extends AbstractNihongoResponse {
	
	private BasicLoginUser user;

	public BasicLoginUser getUser() {
		return user;
	}

	public void setUser(BasicLoginUser user) {
		this.user = user;
	}
}
