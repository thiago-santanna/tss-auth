package com.tsswebapps.tssauth.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuth {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.email, this.password);
	}

}
