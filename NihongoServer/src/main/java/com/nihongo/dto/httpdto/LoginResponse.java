package com.nihongo.dto.httpdto;

import com.nihongo.dto.httpdto.entity.BasicLoginUser;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 7:40:59 PM
 *
 */
public class LoginResponse extends AbstractNihongoResponse {
	
	private BasicLoginUser user;
	
	public LoginResponse() {
		this.code = ResponseCode.SUCCESS;
	}

	public BasicLoginUser getUser() {
		return user;
	}

	public void setUser(BasicLoginUser user) {
		this.user = user;
	}
}
