package com.overlay.exception;

public class UserNameNotFoundExecption extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNameNotFoundExecption(String message) {
		super(message);
	}
}
