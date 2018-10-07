package com.nihongo.dto.httpdto.entity;

import com.nihongo.support.constant.Constant;

public class BasicLoginUser {
	
	private String id;
	private String accessToken;
	private String fullName;
	private String avatarURL;
	private int level;
	private int point;
	private int userType;
	
	public BasicLoginUser() {

	}

	public BasicLoginUser(String id, String accessToken, String fullName, String avatarURL, int level, int point, boolean isAdmin) {
		this.id = id;
		this.accessToken = accessToken;
		this.fullName = fullName;
		this.avatarURL = avatarURL;
		this.level = level;
		this.point = point;
		this.userType = isAdmin ? Constant.USER_TYPE.ADMIN : Constant.USER_TYPE.NORMAL_USER;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
}
