package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:45:42 PM
 *
 */
public class RegisterRequest extends AbstractNihongoRequest {

	private String userName;
	private String password;
	private String fullName;
	private int level;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
