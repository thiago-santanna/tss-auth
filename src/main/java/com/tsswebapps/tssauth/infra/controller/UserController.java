package com.tsswebapps.tssauth.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping
	public UserDto saveUser(@RequestBody UserDto user) {
		return userService.saveUser(user);
	}
}
