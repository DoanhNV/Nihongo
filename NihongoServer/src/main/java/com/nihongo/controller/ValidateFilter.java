package com.nihongo.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Order(1)
public class ValidateFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		System.out.println("filter 2");
		System.out.println(request.getAttribute("requestBody"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/validate/token");
		requestDispatcher.forward(request, httpServletResponse);
	}

}
