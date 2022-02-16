package com.niit.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason="User Not Found.!!___Username or Password didn't matched !")
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

}
