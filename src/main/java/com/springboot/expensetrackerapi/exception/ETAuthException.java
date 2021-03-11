package com.springboot.expensetrackerapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ETAuthException extends RuntimeException{
	
	public ETAuthException(String message) {
		super(message);
	}

}
