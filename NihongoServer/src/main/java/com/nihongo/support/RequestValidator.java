package com.nihongo.support;

import com.nihongo.data.entity.Sort;

/**
 * 
 * @author DoanhNV Jul 29, 2018 10:16:21 PM
 */
public class RequestValidator {
	
	public static boolean isValidSortRequest(Sort sort) {
		if(sort == null) {
			return false;
		} else if(sort.getFieldName() == null || sort.getFieldName().isEmpty()) {
			return false;
		}
		return true;
	} 
}
