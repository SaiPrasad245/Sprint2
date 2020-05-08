package com.cg.sprint2.payment.exceptions;

	@SuppressWarnings("serial")
	public class UserNotFoundException extends Exception {
		
		public UserNotFoundException(String errorMsg){
			super(errorMsg);
		}
	}
