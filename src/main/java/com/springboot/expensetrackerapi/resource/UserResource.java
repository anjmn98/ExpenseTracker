package com.springboot.expensetrackerapi.resource;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.springboot.expensetrackerapi.Constants;
import com.springboot.expensetrackerapi.model.User;
import com.springboot.expensetrackerapi.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
		String email = (String) userMap.get("email");
		String password = (String) userMap.get("password");
		User user = userService.validateUser(email, password);		
		return new ResponseEntity<>(generateJWTToken(user),HttpStatus.OK);
				
	}
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
		String firstName = (String) userMap.get("firstName");
		String lastName = (String) userMap.get("lastName");
		String email = (String) userMap.get("email");
		String password = (String) userMap.get("password");
		User user = userService.registerUser(firstName, lastName, email, password);
		return new ResponseEntity<>(generateJWTToken(user), HttpStatus.CREATED);
	}
	
	public Map<String, String> generateJWTToken(User user){
		long timestamp = System.currentTimeMillis();	//for setting issue date for token and the expiry time
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
				.setIssuedAt(new Date(timestamp))
				.setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
				.claim("userId", user.getUserId())
				.claim("email", user.getEmail())
				.claim("firstName", user.getFirstName())
				.claim("lastName", user.getLastName())
				.compact();
		Map<String, String> map = new HashMap<String, String>();
		map.put("token", token);
		return map;
	}
}
