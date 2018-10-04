package com.nihongo.service.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.nihongo.filter.validation.Validation;
import com.nihongo.filter.validation.implement.DocumentValidation;
import com.nihongo.filter.validation.implement.ExamValidation;
import com.nihongo.filter.validation.implement.FileValidation;
import com.nihongo.filter.validation.implement.MCQQuestionValidation;
import com.nihongo.filter.validation.implement.SettingValidation;
import com.nihongo.filter.validation.implement.UserValidation;
import com.nihongo.support.constant.API.DOCUMENT;
import com.nihongo.support.constant.API.EXAM;
import com.nihongo.support.constant.API.FILE;
import com.nihongo.support.constant.API.MCQ_QUESTION;
import com.nihongo.support.constant.API.SETTING;
import com.nihongo.support.constant.API.USER;
import com.nihongo.support.constant.API.USER_CONNECTION;

/**
 * 
 * @author DoanhNV Aug 17, 2018 3:49:46 PM
 *
 */
public class APIManager {

	private static Map<String, Boolean> tokenAPIs = new TreeMap<>();
	private static Map<String, Boolean> transferHeaderParamAPIMap = new TreeMap<>();
	private static Map<String, Validation> validateAPIMap = new HashMap<>();

	static {
		initTokenAPIMap();
		initValidatorAPIMap();
		initTransferHeaderParamAPIMap();
	}
	
	private static void initTokenAPIMap() {
		tokenAPIs.put(FILE.ROOT + FILE.UPLOAD_BASE64, true);
		tokenAPIs.put(FILE.ROOT + FILE.LOAD_BASE64, true);
		
		tokenAPIs.put(SETTING.ROOT + SETTING.LIST_EXAM_SETTING, true);
		tokenAPIs.put(SETTING.ROOT + SETTING.SET_EXAM_NUMBER, true);
		
		tokenAPIs.put(DOCUMENT.ROOT + DOCUMENT.CREATE, true);
		tokenAPIs.put(DOCUMENT.ROOT + DOCUMENT.GET_BY_ID, true);
		tokenAPIs.put(DOCUMENT.ROOT + DOCUMENT.SEARCH, true);
		tokenAPIs.put(DOCUMENT.ROOT + DOCUMENT.UPDATE, true);
		
		tokenAPIs.put(MCQ_QUESTION.ROOT + MCQ_QUESTION.ROOT, true);
		tokenAPIs.put(MCQ_QUESTION.ROOT + MCQ_QUESTION.SEARCH, true);
		tokenAPIs.put(MCQ_QUESTION.ROOT + MCQ_QUESTION.LIST, true);
		
		tokenAPIs.put(EXAM.ROOT + EXAM.CREATE_RANDOM_EXAM, true);
		tokenAPIs.put(EXAM.ROOT + EXAM.GET_RANDOM_EXAM, true);
		tokenAPIs.put(EXAM.ROOT + EXAM.SEARCH, true);
		tokenAPIs.put(EXAM.ROOT + EXAM.DETAIL, true);
		tokenAPIs.put(EXAM.ROOT + EXAM.UPDATE_BY_ID, true);
		tokenAPIs.put(EXAM.ROOT + EXAM.LIST, true);
		
		tokenAPIs.put(USER.ROOT + USER.REGISTER, false);
		tokenAPIs.put(USER.ROOT + USER.LOGIN, false);
	}
	
	private static void initTransferHeaderParamAPIMap() {
		transferHeaderParamAPIMap.put(USER_CONNECTION.ROOT + USER_CONNECTION.LIKE, true);
	}
	
	private static void initValidatorAPIMap() {
		for (Entry<String, Boolean> entry :  tokenAPIs.entrySet()){
			String uri = entry.getKey();
			if (uri.contains(DOCUMENT.ROOT)) {
				validateAPIMap.put(DOCUMENT.ROOT, new DocumentValidation());
			} else 	if (uri.contains(SETTING.ROOT)) {
				validateAPIMap.put(SETTING.ROOT, new SettingValidation());
			} else 	if (uri.contains(FILE.ROOT)) {
				validateAPIMap.put(FILE.ROOT, new FileValidation());
			}  else if (uri.contains(MCQ_QUESTION.ROOT)) {
				validateAPIMap.put(MCQ_QUESTION.ROOT, new MCQQuestionValidation());
			}  else if (uri.contains(EXAM.ROOT)) {
				validateAPIMap.put(EXAM.ROOT, new ExamValidation());
			}  else if (uri.contains(USER.ROOT)) {
				validateAPIMap.put(USER.ROOT, new UserValidation());
			}
		}
	}

	public static Map<String, Boolean>  getTokenAPIs() {
		return tokenAPIs;
	}

	public static Map<String, Validation> getValidateAPIMap() {
		return validateAPIMap;
	}
	
	public static boolean isTokenAPI(String uri) {
		Boolean isTokenAPI = tokenAPIs.get(uri);
		if (isTokenAPI == null) {
			return false;
		}
		return isTokenAPI;
	}
	
	public static boolean isHeaderTransferParamAPI(String uri) {
		Boolean isHeaderTransferParamAPI = transferHeaderParamAPIMap.get(uri);
		if (isHeaderTransferParamAPI == null) {
			return false;
		}
		return isHeaderTransferParamAPI;
	}

	public static Validation getValidateFilter(String uri) {
		Validation validation = null;
		if (uri.contains(DOCUMENT.ROOT)) {
			validation = validateAPIMap.get(DOCUMENT.ROOT);
		} else 	if (uri.contains(SETTING.ROOT)) {
			validation = validateAPIMap.get(SETTING.ROOT);
		} else 	if (uri.contains(FILE.ROOT)) {
			validation = validateAPIMap.get(FILE.ROOT);
		}  else if (uri.contains(MCQ_QUESTION.ROOT)) {
			validation = validateAPIMap.get(MCQ_QUESTION.ROOT);
		}  else if (uri.contains(EXAM.ROOT)) {
			validation = validateAPIMap.get(EXAM.ROOT);
		}  else if (uri.contains(USER.ROOT)) {
			validation = validateAPIMap.get(USER.ROOT);
		}
		return validation;
	}
}
