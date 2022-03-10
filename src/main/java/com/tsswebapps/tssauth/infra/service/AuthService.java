package com.tsswebapps.tssauth.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.tsswebapps.tssauth.domain.model.User;
import com.tsswebapps.tssauth.dto.TokenDto;
import com.tsswebapps.tssauth.infra.service.generationToken.AuthToken;

@Service
public class AuthService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthToken authToken;

	public TokenDto generationToken(UsernamePasswordAuthenticationToken userLogin) {
		Authentication authenticate = authenticationManager.authenticate(userLogin);
		User authenticatedUser = (User) authenticate.getPrincipal();

		TokenDto tokenDto = authToken.newToken("WEBAPP", authenticatedUser.getId().toString(),
				authenticatedUser.getSecret(), 1800000L);

		return tokenDto;
	}
}
