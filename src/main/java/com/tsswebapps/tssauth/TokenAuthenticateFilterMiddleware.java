package com.tsswebapps.tssauth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.boot.model.source.spi.JoinedSubclassEntitySource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tsswebapps.tssauth.infra.service.generationToken.AuthToken;

public class TokenAuthenticateFilterMiddleware extends OncePerRequestFilter {
	
	private final String AUTHORIZATION = "Authorization";
	
	private AuthToken authToken;

	public TokenAuthenticateFilterMiddleware(AuthToken authToken) {
		this.authToken = authToken;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain) throws ServletException, IOException {
		
		String tokenHeader = getTokenRequest(request);		
		System.out.println(tokenHeader);
		
		boolean tokenValid = authToken.isValid(tokenHeader);
		System.out.println(tokenValid);

		filterChain.doFilter(request, response);		
	}

	private String getTokenRequest(HttpServletRequest request) {
		String token = request.getHeader(AUTHORIZATION);
		if( token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
