package com.tsswebapps.tssauth.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.tssauth.dto.UserDto;
import com.tsswebapps.tssauth.infra.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/resource-protected")
	public ResponseEntity<String> resourceProtected(){
		
		return new ResponseEntity<String>("Hello, você está autorizado a consumir os recursos desta API.", 
				HttpStatus.OK);
	}

	@PostMapping
	public UserDto saveUser(@RequestBody UserDto user) {
		return userService.saveUser(user);
	}
}
