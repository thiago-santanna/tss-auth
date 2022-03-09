package com.tsswebapps.tssauth.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.tssauth.domain.repository.TokenRepository;
import com.tsswebapps.tssauth.dto.TokenDto;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	
	public TokenDto recuperaToken() {
		return null;
	}
	
}
