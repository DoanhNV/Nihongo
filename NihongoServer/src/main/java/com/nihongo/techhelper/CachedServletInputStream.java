package com.nihongo.techhelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class CachedServletInputStream extends ServletInputStream {
	
  private ByteArrayInputStream input;

  public CachedServletInputStream(ByteArrayOutputStream cachedBytes) {
    input = new ByteArrayInputStream(cachedBytes.toByteArray());
  }

  @Override
  public int read() throws IOException {
    return input.read();
  }

	@Override
	public boolean isFinished() {
		return input.read() == -1;
	}

	@Override
	public boolean isReady() {
		return input.read() != -1;
	}

	@Override
	public void setReadListener(ReadListener listener) {
		
	}
}