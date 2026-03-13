package com.songhwa.insulin.exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
