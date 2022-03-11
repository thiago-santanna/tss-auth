package com.tsswebapps.tssauth.infra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.tssauth.dto.TokenDto;
import com.tsswebapps.tssauth.dto.UserAuth;
import com.tsswebapps.tssauth.infra.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
		
	@Autowired
	private AuthService authService;
	
	@PostMapping
	public ResponseEntity<TokenDto> onAuth(@RequestBody @Valid UserAuth user){
		try {	
			TokenDto accessToken = authService.generationToken(user.converter());
			
			return new ResponseEntity<>(accessToken, HttpStatus.CREATED);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
