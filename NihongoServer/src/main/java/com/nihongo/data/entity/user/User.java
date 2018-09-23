package com.nihongo.data.entity.user;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:34:28 PM
 *
 */
public class User extends AbstractEntity {

	private String userName;
	private String password;
	private String fullName;
	private String avatarURL;
	private String gmail;
	private String facebookId;
	private int birthday;
	private int level;
	private int point;
	private long createTime;
	
	public User() {

	}
	
	public User(String id) {
		this.id = id;
	}

	public User( String password, int level, String fullName) {
		this.password = password;
		this.level = level;
		this.fullName = fullName;
	}
	
	public User(String userName, String password, int level, String fullName) {
		this.userName = userName;
		this.password = password;
		this.level = level;
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
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

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
