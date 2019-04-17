package com.nihongo.support.constant;

import com.nihongo.data.entity.user.User;

/**
 * 
 * @author admin
 *
 */
public class LoginSystemUserTemplate extends User {
	
	public final String userName = "SystemLogin@nihongo.com";
	public final String password = "SystemLoginAuthen@nihongo.com";
	public final String fullName = "System login";
	public final String avatarURL = "";
	public final String gmail = "";
	public final String facebookId = "";
	public final int birthday = 20190417;
	public final int level = 1;
	public final int point = 0;
	public final long createTime = 0;
	public final boolean isAdmin = false ;
	public final boolean isSystemUser = true;
}
