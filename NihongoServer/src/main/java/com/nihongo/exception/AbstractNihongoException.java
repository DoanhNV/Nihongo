package com.nihongo.exception;

/**
 * 
 * @author DoanhNV Jul 7, 2018 8:55:00 PM
 */
public class AbstractNihongoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private float code;
	private String message;

	public AbstractNihongoException() {

	}

	public AbstractNihongoException(String message, float code) {
		this.code = code;
	}

	public AbstractNihongoException(float code, String message) {
		this.code = code;
		this.message = message;
	}

	public AbstractNihongoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AbstractNihongoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractNihongoException(String message) {
		super(message);
	}

	public AbstractNihongoException(Throwable cause) {
		super(cause);
	}

	public float getCode() {
		return code;
	}

	public void setCode(float code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}