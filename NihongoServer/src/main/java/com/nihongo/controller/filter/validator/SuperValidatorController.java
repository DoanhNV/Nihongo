package com.nihongo.controller.filter.validator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.techentity.FilterValidation;

/**
 * 
 * @author DoanhNV Aug 17, 2018 5:45:39 PM
 *
 */
@RestController
@RequestMapping(value = "/validate")
public class SuperValidatorController {
	
	@RequestMapping(value = "/token", method = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE } )
	@ResponseBody
	public JSONObject validate(@RequestBody FilterValidation validate, HttpServletRequest request, HttpServletResponse httpServletResponse) throws ServletException, IOException, ParseException {
		JSONObject validateResponse = new JSONObject();
		boolean isValidRequest = false;
		Map<String, Object> mapResponse = new HashMap<>();
		mapResponse.put("code", 1);
		mapResponse.put("message", "invalid token");
		validateResponse.putAll(mapResponse);
		String requestURI = (String) request.getAttribute("request_uri");
		String token = request.getHeader("token");
		if(isValidRequest) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(requestURI);
			requestDispatcher.forward(request, httpServletResponse);
		}
		return validateResponse;
	} 
}
