package com.tsswebapps.tssauth.configuration;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tsswebapps.tssauth.domain.model.User;
import com.tsswebapps.tssauth.domain.repository.UserRepository;

@Service
public class AuthenticatedService implements UserDetailsService {
	
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> usuario = repository.findByEmail(username);
		
		if (usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Usuario ou senha inválidos.");
	}

}
