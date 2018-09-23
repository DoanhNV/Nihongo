package com.nihongo.service.pojo;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 8:25:27 PM
 *
 */
public class TokenKey implements Comparable<TokenKey> {

	private String userId;
	private String token;

	public TokenKey(String userId, String token) {
		this.userId = userId;
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenKey other = (TokenKey) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenKey [userId=" + userId + ", token=" + token + "]";
	}

	@Override
	public int compareTo(TokenKey tokenKey) {
		return this.getUserId().compareTo(tokenKey.getUserId());
	}
}
