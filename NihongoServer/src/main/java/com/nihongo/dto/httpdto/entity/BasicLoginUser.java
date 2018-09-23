package com.nihongo.dto.httpdto.entity;

public class BasicLoginUser {
	
	private String id;
	private String accessToken;
	private String fullName;
	private String avatarURL;
	private int level;
	private int point;
	
	public BasicLoginUser() {

	}

	public BasicLoginUser(String id, String accessToken, String fullName, String avatarURL, int level, int point) {
		this.id = id;
		this.accessToken = accessToken;
		this.fullName = fullName;
		this.avatarURL = avatarURL;
		this.level = level;
		this.point = point;
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
}
