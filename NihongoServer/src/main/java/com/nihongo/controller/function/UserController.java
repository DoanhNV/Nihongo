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
import com.nihongo.dto.httpdto.request.LoginRequest;
import com.nihongo.dto.httpdto.request.RegisterRequest;
import com.nihongo.dto.httpdto.response.RegisterResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.UserService;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:32:57 PM
 *
 */
@CrossOrigin
@RestController
@RequestMapping( value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/register")
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
		}
		return response;
	}
	
	@PostMapping(value = "/login")
	@ResponseBody
	public LoginResponse login(@RequestBody LoginRequest request) {
		LoginResponse response = new LoginResponse();
		try {
			BasicLoginUser user = userService.login(request.getLoginAlias(), request.getPassword(), request.getLoginType(), request.getFullName(), request.getLevel());
			response.setUser(user);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	} 
}
