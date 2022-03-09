package com.tsswebapps.tssauth.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.tssauth.dto.TokenDto;
import com.tsswebapps.tssauth.infra.service.TokenService;

@RestController
public class TokenController {
	
	@Autowired
	private TokenService tokenService;

	public TokenDto gerarToken() {
		TokenDto token = tokenService.execute();
		return token;
	}
}
