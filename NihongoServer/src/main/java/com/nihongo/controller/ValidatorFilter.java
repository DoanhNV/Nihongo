package com.nihongo.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.nihongo.support.constant.Constant.CONTENT_TYPE;
import com.nihongo.support.constant.Constant.REQUEST_PROPERTIES;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.techhelper.MultiReadHttpServletRequest;

/**
 * 
 * @author DoanhNV Aug 17, 2018 5:45:16 PM
 *
 */
@Component
@Order(Constant.FILTER_ORDER.SECOND)
public class ValidatorFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		MultiReadHttpServletRequest httpServletRequest = (MultiReadHttpServletRequest) request;
		
		StringBuilder requestBody = new StringBuilder((String) request.getAttribute(REQUEST_PROPERTIES.REQUEST_BODY));
		String requestURI = httpServletRequest.getRequestURI();
		String token = httpServletRequest.getHeader(REQUEST_PROPERTIES.ACCESS_TOKEN);
		
		boolean isPreFlightRequest = isPreFlightRequest(httpServletRequest);
		AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
		if (!isPreFlightRequest) {
			validateResponse = NihongoFilter.validate(token, requestBody, requestURI);
			changeBodyAfterTransferFromHeader(httpServletRequest, requestBody.toString());
		}
		
		if(validateResponse.getCode() == ResponseCode.SUCCESS) {
			chain.doFilter(httpServletRequest, httpServletResponse);
		} else {
			PrintWriter writer = httpServletResponse.getWriter();
			httpServletResponse.setContentType(CONTENT_TYPE.APPLICATION_JSON);
			httpServletResponse.setCharacterEncoding(Constant.ENCODING.UTF_8);
			writer.write(validateResponse.toJson().toJSONString());
			//writer.print(validateResponse.toJson().toJSONString());
			writer.flush();
		}
	}
	
	private void changeBodyAfterTransferFromHeader(MultiReadHttpServletRequest httpServletRequest, String requestBody) throws IOException {
		httpServletRequest.setBody(requestBody);
	}
	
	private boolean isPreFlightRequest(HttpServletRequest httpServletRequest) {
		final String PREFLIGHT_METHOD = "OPTIONS";
		String method = httpServletRequest.getMethod();
		String contentType = httpServletRequest.getContentType();
		return method.equals(PREFLIGHT_METHOD) && contentType == null;
	}
}
