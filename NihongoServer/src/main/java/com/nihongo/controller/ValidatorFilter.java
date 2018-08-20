package com.nihongo.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.filter.validation.NihongoFilter;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Aug 17, 2018 5:45:16 PM
 *
 */
@Component
@Order(Constant.FILTER_ORDER.SECOND)
public class ValidatorFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String requestBody = (String) request.getAttribute(Constant.REQUEST_PROPERTIES.REQUEST_BODY);
		String requestURI = httpServletRequest.getRequestURI();
		String token = httpServletRequest.getHeader(Constant.REQUEST_PROPERTIES.ACCESS_TOKEN);
		AbstractNihongoResponse validateResponse = NihongoFilter.validate(token, requestBody, requestURI);
		
		if(validateResponse.getCode() == ResponseCode.SUCCESS) {
			chain.doFilter(httpServletRequest, httpServletResponse);
		} else {
			response.getWriter().write(validateResponse.toJson().toJSONString());
		}
	}

}
