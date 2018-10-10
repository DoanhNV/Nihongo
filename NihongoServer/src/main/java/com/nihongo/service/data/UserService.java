package com.nihongo.service.data;

import com.nihongo.dto.httpdto.entity.BasicLoginUser;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:55:52 PM
 *
 */
public interface UserService {
	
	public BasicLoginUser createUser(String userName, String password, int level, String fullName);
	
	public BasicLoginUser login(String loginAlias, String password, int loginType, String fullName, int level);
	
	public void logout(String token);
}
