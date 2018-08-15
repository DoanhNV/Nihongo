package com.nihongo.techhelper;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

	private ByteArrayOutputStream cachedBytes;

	public MultiReadHttpServletRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		if (cachedBytes == null)
			cacheInputStream();
		return new CachedServletInputStream(cachedBytes);
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	private void cacheInputStream() throws IOException {
		cachedBytes = new ByteArrayOutputStream();
		IOUtils.copy(super.getInputStream(), cachedBytes);
	}
	
	@Override
	public String getRequestURI() {
		return "/document/create";
	}
	
	@Override
	public StringBuffer getRequestURL() {
		return new StringBuffer("http://localhost:6868/document/create");
	}

	@Override
	public String getServletPath() {
		return "http://localhost:6868/document/create";
	}
	
	public String getBody() throws IOException {
		String body = "";
		InputStreamReader reader = new InputStreamReader(getInputStream());
		int c = 0;
		while ((c = reader.read()) != -1) {
			char character = (char) c;
			body += character;
		}
		return body;
	}
}