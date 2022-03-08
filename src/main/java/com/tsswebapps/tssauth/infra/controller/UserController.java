package com.tsswebapps.tssauth.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.tssauth.dto.UserInputDto;
import com.tsswebapps.tssauth.infra.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserInputDto saveUser(UserInputDto user) {
		UserInputDto userSaved = userService.saveUser(user);
		return userSaved;
	}
}
