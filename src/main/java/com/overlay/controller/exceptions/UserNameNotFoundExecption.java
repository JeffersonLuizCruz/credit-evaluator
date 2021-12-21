package com.overlay.controller.exceptions;

public class UserNameNotFoundExecption extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNameNotFoundExecption(String message) {
		super(message);
	}
}
