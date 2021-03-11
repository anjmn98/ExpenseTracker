package com.springboot.expensetrackerapi.service;

import com.springboot.expensetrackerapi.exception.ETAuthException;
import com.springboot.expensetrackerapi.model.User;

public interface UserService {
	
	User validateUser( String email, String password) throws ETAuthException;
	
	User registerUser(String firstName, String lastName, String email, String password) throws ETAuthException;
	
	
}
