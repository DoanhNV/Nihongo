package com.nihongo.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.nihongo.techhelper.MultiReadHttpServletRequest;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SuperFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		MultiReadHttpServletRequest multipleRequest = new MultiReadHttpServletRequest(httpServletRequest);

		System.out.println("request: " + multipleRequest.getScheme() + "://" + multipleRequest.getServerName() + ":" + multipleRequest.getServerPort());
		System.out.println("getServletPath: " + multipleRequest.getServletPath());
		System.out.println("getRequestURI: " + multipleRequest. getRequestURI());
		System.out.println("getRequestURL: " + multipleRequest.getRequestURL());
		String remoteString = multipleRequest.getRemoteAddr() + " == "+ multipleRequest.getRemoteHost()
		                     + " == " + multipleRequest.getRemotePort() + " == " + multipleRequest.getRemoteUser();
		String saveUrl = (String) httpServletRequest.getParameter("saveUrl");
		httpServletResponse.setHeader(HttpHeaders.LOCATION, "/document/create");
		multipleRequest.setAttribute("requestBody", multipleRequest.getBody());
		chain.doFilter(multipleRequest, httpServletResponse);
	}
}
