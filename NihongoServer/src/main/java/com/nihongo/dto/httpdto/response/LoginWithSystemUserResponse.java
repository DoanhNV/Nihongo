package com.nihongo.dto.httpdto.response;

import com.nihongo.dto.httpdto.entity.BasicLoginUser;

/**
 * 
 * @author DoanhNV Apr 18, 2019 - 2:38:18 PM
 *
 */
public class LoginWithSystemUserResponse extends AbstractNihongoResponse {
	
	private BasicLoginUser user;

	public BasicLoginUser getUser() {
		return user;
	}

	public void setUser(BasicLoginUser user) {
		this.user = user;
	}
}
