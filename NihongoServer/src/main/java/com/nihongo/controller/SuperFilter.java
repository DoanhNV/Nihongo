package com.nihongo.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.FilterChain;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class SuperFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		MultiReadHttpServletRequest multipleRequest = new MultiReadHttpServletRequest(httpServletRequest);

		System.out.println("request: " + multipleRequest.getScheme() + "://" + multipleRequest.getServerName() + ":" + multipleRequest.getServerPort()
																	 + multipleRequest.getQueryString());
		String remoteString = multipleRequest.getRemoteAddr() + " == "+ multipleRequest.getRemoteHost()
		                     + " == " + multipleRequest.getRemotePort() + " == " + multipleRequest.getRemoteUser();
		ServletInputStream inputStream = multipleRequest.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		int c = 0;
		String requestString = "";
		while((c = reader.read()) != -1) {
			char character = (char) c;
			requestString += character;
		}
		System.out.println(requestString);
		
		chain.doFilter(request, response);
	}
	
	
	
	public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {
		
	  private ByteArrayOutputStream cachedBytes;

	  public MultiReadHttpServletRequest(HttpServletRequest request) {
	    super(request);
	  }

	  @Override
	  public ServletInputStream getInputStream() throws IOException {
	    if (cachedBytes == null)
	      cacheInputStream();

	      return new CachedServletInputStream();
	  }

	  @Override
	  public BufferedReader getReader() throws IOException{
	    return new BufferedReader(new InputStreamReader(getInputStream()));
	  }

	  private void cacheInputStream() throws IOException {
	    /* Cache the inputstream in order to read it multiple times. For
	     * convenience, I use apache.commons IOUtils
	     */
	    cachedBytes = new ByteArrayOutputStream();
	    IOUtils.copy(super.getInputStream(), cachedBytes);
	  }

	  /* An inputstream which reads the cached request body */
	  public class CachedServletInputStream extends ServletInputStream {
	    private ByteArrayInputStream input;

	    public CachedServletInputStream() {
	      /* create a new input stream from the cached request body */
	      input = new ByteArrayInputStream(cachedBytes.toByteArray());
	    }

	    @Override
	    public int read() throws IOException {
	      return input.read();
	    }

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener listener) {
				
			}
	  }
	}
}
