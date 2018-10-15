package com.nihongo.controller;

import java.io.ByteArrayOutputStream;
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

import com.nihongo.support.constant.Constant;
import com.nihongo.techhelper.MultiReadHttpServletRequest;

/**
 * 
 * @author DoanhNV Aug 17, 2018 5:45:26 PM
 *
 */
@Component
@Order(Constant.FILTER_ORDER.FIRST)
public class SuperFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		MultiReadHttpServletRequest multipleRequest = new MultiReadHttpServletRequest(httpServletRequest);
		
		String requestBody = multipleRequest.getBody();
		multipleRequest.setAttribute(Constant.REQUEST_PROPERTIES.REQUEST_BODY, requestBody);
		
		chain.doFilter(multipleRequest, httpServletResponse);
	}
}
