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
	
	public static UserInputDto userToUserInputDto(User user) {
		return new UserInputDto(user.getId(), user.getName(), user.getEmail(), null);
	}

	@Override
	public String toString() {
		return "UserInputDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
