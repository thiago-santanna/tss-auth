package com.tsswebapps.tssauth.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.tssauth.domain.model.Token;
import com.tsswebapps.tssauth.domain.repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	
	public void execute(Token token) {
		 tokenRepository.save(token);
	}
	
}
