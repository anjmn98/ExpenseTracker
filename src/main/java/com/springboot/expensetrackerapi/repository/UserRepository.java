package com.springboot.expensetrackerapi.repository;

import com.springboot.expensetrackerapi.exception.ETAuthException;
import com.springboot.expensetrackerapi.model.User;

public interface UserRepository {
	
	Integer create(String firstName, String lastName, String email, String password) throws ETAuthException;
	
	User findByEmailAndPassword(String email, String password) throws ETAuthException;
	
	Integer getCountByEmail(String email);
	
	User findById(Integer userId);
}
