package com.nihongo.controller.validator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.techentity.Validation;
import com.nihongo.dto.httpdto.response.NihongoResponse;

@RestController
@RequestMapping(value = "/validate")
public class SuperValidator {
	
	@RequestMapping(value = "/token", method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE} )
	@ResponseBody
	public String validate(@RequestBody Validation validate,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		NihongoResponse invalidResponse = new NihongoResponse();
		Map<String, Object> mapResponse = new HashMap<>();
		mapResponse.put("code", 1);
		mapResponse.put("message", "invalid token");
		response.sendRedirect(request.getRequestURI());
		return "redirect:/test/search";
	} 
}
