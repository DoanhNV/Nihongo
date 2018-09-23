package com.nihongo.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihongo.data.dao.UserDAO;
import com.nihongo.data.entity.user.User;
import com.nihongo.dto.httpdto.entity.BasicLoginUser;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.UserService;
import com.nihongo.service.manager.TokenManager;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:58:27 PM
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public BasicLoginUser createUser(String userName, String password, int level, String fullName) {
		User user = new User(userName, password, level, fullName);
		if (userDAO.existUser(userName, user.getGmail(), user.getFacebookId())) {
			throw new AbstractNihongoException(ResponseCode.EXISTED_USER_NAME);
		}
		
		User registerUser = userDAO.createUser(user);
		String accessToken = TokenManager.createToken(registerUser.getId(), registerUser.getPassword());
		BasicLoginUser basicUser = new BasicLoginUser(registerUser.getId(), 
																	accessToken, 
																	registerUser.getFullName(),
																	registerUser.getAvatarURL(), 
																	registerUser.getLevel(), 
																	registerUser.getPoint());
		return basicUser;
	}

	@Override
	public BasicLoginUser login(String loginAlias, String password, int loginType, String fullName, int level) {
		User user = userDAO.login(loginAlias, password, loginType);
		boolean isNotExistUser = user == null;
		boolean isLoginBySocialNetWork = loginType != Constant.LOGIN_TYPE.BY_USER_NAME;
		
		if (isNotExistUser && isLoginBySocialNetWork) {
			User registerUser = new User(password, level, fullName);
			switch (loginType) {
				case Constant.LOGIN_TYPE.BY_GMAIL:
					registerUser.setGmail(loginAlias);
					break;
				case Constant.LOGIN_TYPE.BY_FACEBOOK:
					registerUser.setFacebookId(loginAlias);
					break;
			}
			user = userDAO.createUser(registerUser);
		} else if(isNotExistUser) {
			throw new AbstractNihongoException(ResponseCode.USER_NOT_EXIST);
		}
		
		String accessToken = TokenManager.createToken(user.getId(), user.getPassword());
		BasicLoginUser basicUser = new BasicLoginUser(user.getId(), 
																	accessToken, 
																	user.getFullName(),
																	user.getAvatarURL(), 
																	user.getLevel(),
																	user.getPoint());
		return basicUser;
	}
	
	
}
