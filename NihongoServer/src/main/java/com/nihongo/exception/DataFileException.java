package com.nihongo.exception;

/**
 * 
 * @author DoanhNV Jul 8, 2018 2:24:26 PM
 */
public class DataFileException extends AbstractNihongoException {

	private static final long serialVersionUID = 1L;
	

	public DataFileException (float code) {
		this.setCode(code);
	} 
	
	public DataFileException (float code, String message) {
		this.setCode(code);
	} 

}
