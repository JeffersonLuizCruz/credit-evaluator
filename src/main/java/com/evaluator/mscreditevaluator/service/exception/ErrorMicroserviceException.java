package com.evaluator.mscreditevaluator.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.GATEWAY_TIMEOUT)
public class ErrorMicroserviceException extends RuntimeException{
	private static final long serialVersionUID = 4348340970344904438L;

	public ErrorMicroserviceException(String message) {
		super(message);
	}
}
