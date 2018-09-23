package com.nihongo.dto.httpdto.request;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 7:37:54 PM
 *
 */
public class LoginRequest extends AbstractNihongoRequest {

	private String loginAlias;
	private String password;
	private int loginType;
	private String fullName;
	private int level;

	public String getLoginAlias() {
		return loginAlias;
	}

	public void setLoginAlias(String loginAlias) {
		this.loginAlias = loginAlias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
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
