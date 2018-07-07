package com.nihongo.httpdto.response;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:15:35 PM
 */
public class MCQQuestionResponse extends AbstractResponse {

	public static class CreatResponse extends MCQQuestionResponse {
		
		public CreatResponse(float code) {
			this.code = code;
		}

		public CreatResponse(float code, String message) {
			this.code = code;
			this.message = message;
		}
		
	}
}
