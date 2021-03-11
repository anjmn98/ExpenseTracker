package com.springboot.expensetrackerapi.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.expensetrackerapi.exception.ETAuthException;
import com.springboot.expensetrackerapi.model.User;
import com.springboot.expensetrackerapi.repository.UserRepository;

@Service
@Transactional	//on adding this annotation, the transaction commit will be successful only when method executes succesfully
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepository;
	@Override
	public User validateUser(String email, String password) throws ETAuthException {
		if(email!=null) email.toLowerCase();
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public User registerUser(String firstName, String lastName, String email, String password) throws ETAuthException {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if(email!=null) email=email.toLowerCase();
		if(!pattern.matcher(email).matches())
			throw new ETAuthException("Invalid email format");
		Integer count = userRepository.getCountByEmail(email);
		if(count > 0) 
			throw new ETAuthException("Email aready in use");
		Integer userId = userRepository.create(firstName, lastName, email, password);
		return userRepository.findById(userId);
	}
	
	
}
