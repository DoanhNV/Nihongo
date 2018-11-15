package com.nihongo.monitor;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 
 * @author DoanhNV Nov 5, 2018 - 10:46:38 PM
 *
 */
public class LogManager {
	
	final static Logger logger = Logger.getRootLogger();
	
	public static void logInfo(String message) {
		logger.info(message);
	}
	
	public static void logDebug(String prefix, String api, String message) {
		final String SEPARATOR = " : ";
		logger.debug(prefix + SEPARATOR + api + SEPARATOR + message);
	}
	
	public static void logError(Throwable t) {
		logger.error(new Date(), t);
	}
}
