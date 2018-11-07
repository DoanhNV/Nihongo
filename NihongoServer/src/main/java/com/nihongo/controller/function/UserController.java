package com.nihongo.controller.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.dto.httpdto.LoginResponse;
import com.nihongo.dto.httpdto.entity.BasicLoginUser;
import com.nihongo.dto.httpdto.request.GetUserInfoRequest;
import com.nihongo.dto.httpdto.request.LoginRequest;
import com.nihongo.dto.httpdto.request.LogoutRequest;
import com.nihongo.dto.httpdto.request.RegisterRequest;
import com.nihongo.dto.httpdto.response.GetUserInfoResponse;
import com.nihongo.dto.httpdto.response.LogoutResponse;
import com.nihongo.dto.httpdto.response.RegisterResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.monitor.LogManager;
import com.nihongo.service.data.UserService;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:32:57 PM
 *
 */
@CrossOrigin
@RestController
@RequestMapping( value = API.USER.ROOT)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = API.USER.REGISTER)
	@ResponseBody
	public RegisterResponse register(@RequestBody RegisterRequest request) {
		RegisterResponse response = new RegisterResponse();
		try {
			BasicLoginUser user = userService.createUser(request.getUserName(), request.getPassword(), request.getLevel(), request.getFullName());
			response.setUser(user);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
			LogManager.logError(e);
		}
		return response;
	}
	
	@PostMapping(value = API.USER.LOGIN)
	@ResponseBody
	public LoginResponse login(@RequestBody LoginRequest request) {
		LoginResponse response = new LoginResponse();
		try {
			BasicLoginUser user = userService.login(request.getLoginAlias(), request.getPassword(), request.getLoginType(), request.getFullName(), request.getLevel());
			response.setUser(user);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
			LogManager.logError(e);
		}
		return response;
	}
	
	@PostMapping(value = API.USER.LOGOUT)
	@ResponseBody
	public LogoutResponse logout(@RequestBody LogoutRequest request) {
		LogoutResponse response = new LogoutResponse();
		try {
			userService.logout(request.getToken());
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
			LogManager.logError(e);
		}
		return response;
	}
	
	@PostMapping(value = API.USER.INFO)
	@ResponseBody
	public GetUserInfoResponse getUserInfo(@RequestBody GetUserInfoRequest request) {
		GetUserInfoResponse response = new GetUserInfoResponse();
		try {
			BasicLoginUser basicUser = userService.getBasicUserInfo(request.getRequestUserId());
			response.setUser(basicUser);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
			LogManager.logError(e);
		}
		return response;
	}
}
