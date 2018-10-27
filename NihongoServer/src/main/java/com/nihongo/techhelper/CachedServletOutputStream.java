package com.nihongo.techhelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * 
 * @author DoanhNV Oct 24, 2018 - 10:39:22 PM
 *
 */
public class CachedServletOutputStream extends ServletOutputStream {
	
	private ByteArrayOutputStream byteOSCached = new ByteArrayOutputStream();
	
	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public void setWriteListener(WriteListener listener) {

	}

	@Override
	public void write(int b) throws IOException {
		this.byteOSCached.write(b);
	}
	
	public ByteArrayInputStream toByteArrayInputStream() throws UnsupportedEncodingException {
		return new ByteArrayInputStream(this.byteOSCached.toString(StandardCharsets.UTF_8.toString()).getBytes());
	}
	
	public String getBody() throws UnsupportedEncodingException {
		return byteOSCached.toString(StandardCharsets.UTF_8.toString());
	}
}
