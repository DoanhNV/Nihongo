package com.nihongo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;
import com.nihongo.filter.validation.NihongoFilter;
import com.nihongo.monitor.LogManager;
import com.nihongo.security.TokenUtil;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.FilterTransferParam;
import com.nihongo.support.constant.Constant.CONTENT_TYPE;
import com.nihongo.support.constant.Constant.REQUEST_PROPERTIES;
import com.nihongo.support.constant.ResponseCode;
import com.nihongo.techhelper.CachedServletOutputStream;
import com.nihongo.techhelper.MultiReadHttpServletRequest;
import com.nihongo.techhelper.ReadableHttpServletResponse;

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
		
		try {
			ReadableHttpServletResponse readableHttpServletResponse = (ReadableHttpServletResponse) response;
			MultiReadHttpServletRequest httpServletRequest = (MultiReadHttpServletRequest) request;
			
			
			readableHttpServletResponse.setContentType(CONTENT_TYPE.APPLICATION_JSON);
			readableHttpServletResponse.setCharacterEncoding(Constant.ENCODING.UTF_8);
			
			StringBuilder requestBody = new StringBuilder((String) request.getAttribute(REQUEST_PROPERTIES.REQUEST_BODY));
			String requestURI = httpServletRequest.getRequestURI();
			String token = httpServletRequest.getHeader(REQUEST_PROPERTIES.ACCESS_TOKEN);
			
			boolean isPreFlightRequest = isPreFlightRequest(httpServletRequest);
			AbstractNihongoResponse validateResponse = new AbstractNihongoResponse();
			if (!isPreFlightRequest) {
				validateResponse = NihongoFilter.validate(token, requestBody, requestURI);
				if (validateResponse.getCode() == ResponseCode.SUCCESS) {
					transferParamForGetRequest(httpServletRequest);
					changeBodyAfterTransferFromHeader(httpServletRequest, requestBody.toString());
				}
			}
			
			LogManager.logDebug(Constant.LOGGER.REQUEST_PREFIX, requestURI, requestBody.toString());
			
			String responseBody = "{}";
			if(validateResponse.getCode() == ResponseCode.SUCCESS) {
				chain.doFilter(httpServletRequest, readableHttpServletResponse);
				
				if (!isPreFlightRequest) {
					CachedServletOutputStream outputStream = (CachedServletOutputStream) readableHttpServletResponse.getOutputStream();
					String body = outputStream.getBody();
					responseBody = body;
					LogManager.logDebug(Constant.LOGGER.REPONSE_PREFIX, requestURI, responseBody);
					
					
					// ENCRYPT
					/*responseBody = AesUtil.getInstance().encrypt(body);
					
					JSONObject jsonResponse = new JSONObject();
					jsonResponse.put(Constant.RESPONSE_PARAM.DATA, responseBody);
					responseBody = jsonResponse.toJSONString();*/
				}
			} else {
				responseBody = validateResponse.toJson().toJSONString();
				LogManager.logDebug(Constant.LOGGER.REPONSE_PREFIX, requestURI, responseBody);
			}
			
			
			if (!isPreFlightRequest) { 
				PrintWriter writer = readableHttpServletResponse.getWriter();
				writer.write(responseBody);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LogManager.logError(e);
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
	
	private void transferParamForGetRequest(MultiReadHttpServletRequest httpServletRequest) {
		String requestURI = httpServletRequest.getRequestURI();
		final String DETAIL_ALIAS = API.EXAM.ROOT + API.EXAM.DETAIL_ALIAS;
		final String EXAM_HISTORY_API = API.EXAM.ROOT + API.EXAM.LIST_HISTORY;
		
		if(requestURI.contains(DETAIL_ALIAS) || requestURI.contains(EXAM_HISTORY_API)) {
			String token = httpServletRequest.getHeader(REQUEST_PROPERTIES.ACCESS_TOKEN);
			String userId = TokenUtil.getUserId(token);
			httpServletRequest.setAttribute(FilterTransferParam.USER_ID, userId);
		}
	}
}
