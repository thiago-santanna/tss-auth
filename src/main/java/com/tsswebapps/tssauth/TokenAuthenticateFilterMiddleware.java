package com.tsswebapps.tssauth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class TokenAuthenticateFilterMiddleware extends OncePerRequestFilter {
	
	private final String AUTHORIZATION = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain) throws ServletException, IOException {
		
		String tokenHeader = getTokenRequest(request);
		
		System.out.println(tokenHeader);

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
