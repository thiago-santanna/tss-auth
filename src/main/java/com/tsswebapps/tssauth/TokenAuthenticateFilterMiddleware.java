package com.tsswebapps.tssauth;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tsswebapps.tssauth.domain.model.User;
import com.tsswebapps.tssauth.domain.repository.UserRepository;
import com.tsswebapps.tssauth.infra.service.generationToken.AuthToken;

public class TokenAuthenticateFilterMiddleware extends OncePerRequestFilter {
	
	private final String AUTHORIZATION = "Authorization";
	
	private AuthToken authToken;
	
	private UserRepository userRepository;

	public TokenAuthenticateFilterMiddleware(AuthToken authToken, UserRepository userRepository) {
		this.authToken = authToken;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain) throws ServletException, IOException {
		
		String tokenHeader = getTokenRequest(request);		
		
		boolean tokenValid = authToken.isValid(tokenHeader);
		
		if (tokenValid) {
			authenticationUser(tokenHeader);
		}

		filterChain.doFilter(request, response);		
	}

	private void authenticationUser(String tokenHeader) {
		Long idUser = authToken.getUserIdToken(tokenHeader);
		
		System.out.println(idUser);
		
		Optional<User> optional = userRepository.findById(idUser);
		
		if(optional.isPresent()) {
			System.out.println(optional.get());
			
			UsernamePasswordAuthenticationToken authentication = new 
					UsernamePasswordAuthenticationToken(optional.get(), null, optional.get().getAuthorities() );
			
			SecurityContextHolder.getContext().setAuthentication(authentication);			
		}		
	}

	private String getTokenRequest(HttpServletRequest request) {
		String token = request.getHeader(AUTHORIZATION);
		
		if( token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
