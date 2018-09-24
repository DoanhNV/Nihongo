package com.nihongo.support.util;

import org.bson.types.ObjectId;

/**
 * 
 * @author DoanhNV Sep 24, 2018 5:22:44 PM
 *
 */
public class ValidatorUtil {

	public static boolean isValidObjectId(String userId) {
		try {
			new ObjectId(userId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
