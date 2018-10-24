package com.nihongo.techhelper;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ReadableHttpServletResponse extends HttpServletResponseWrapper implements HttpServletResponse {

	public ReadableHttpServletResponse(HttpServletResponse response) {
		super(response);
	}

	private CachedServletOutputStream cachedServletOutputStream = new CachedServletOutputStream();

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return cachedServletOutputStream;
	}
}
