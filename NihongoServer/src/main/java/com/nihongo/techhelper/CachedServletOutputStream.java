package com.nihongo.techhelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
	
	public ByteArrayInputStream toByteArrayInputStream() {
		return new ByteArrayInputStream(this.byteOSCached.toByteArray());
	}
	
	public String getBody() {
		ByteArrayInputStream byteArrayInputStream = toByteArrayInputStream();
		String responseBody = "";
		int tempCharacter = 0;

		while ((tempCharacter = byteArrayInputStream.read()) != -1) {
			responseBody += (char) tempCharacter;
		}
		if(responseBody.isEmpty()) {
			responseBody = "{}";
		}
		return responseBody;
	}
}
