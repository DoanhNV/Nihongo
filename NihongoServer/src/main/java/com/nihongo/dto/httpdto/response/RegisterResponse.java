package com.nihongo.dto.httpdto.response;

import com.nihongo.dto.httpdto.entity.BasicLoginUser;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:49:37 PM
 *
 */
public class RegisterResponse extends AbstractNihongoResponse {

	private BasicLoginUser user;
	
	public RegisterResponse() {
		this.code = ResponseCode.SUCCESS;
	}

	public BasicLoginUser getUser() {
		return user;
	}

	public void setUser(BasicLoginUser user) {
		this.user = user;
	}
}
