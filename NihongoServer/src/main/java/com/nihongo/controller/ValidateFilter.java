package com.nihongo.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 * 
 * @author DoanhNV Aug 17, 2018 5:45:16 PM
 *
 */
@Component
@Order(1)
public class ValidateFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Object body = request.getAttribute("requestBody");
		request.setAttribute("request_uri", httpRequest.getRequestURI());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/validate/token");
		requestDispatcher.forward(request, httpServletResponse);
	}

}
