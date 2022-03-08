package com.tsswebapps.tssauth.dto;

import com.tsswebapps.tssauth.domain.model.User;

public class UserInputDto {
	private Long id;
	private String name;
	private String email;
	private String password;

	public UserInputDto(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public User toUser() {
		return new User(this.id, this.email, this.name, this.password, null, null);
	}

}
