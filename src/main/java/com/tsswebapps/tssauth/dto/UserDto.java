package com.tsswebapps.tssauth.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.tsswebapps.tssauth.domain.model.User;

public class UserDto {
	private Long id;
	private String name;
	private String email;
	private String password;
	private List<RoleDto> roles = new ArrayList<>();
	
	public UserDto() {
		System.out.println("1");
	}

	public UserDto(Long id, String name, String email, String password, List<RoleDto> roles) {
		System.out.println("2");
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;		
	}
	
	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
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
	
	public List<RoleDto> getRolesDto() {
		return Collections.unmodifiableList(this.roles);
	}

	public static UserDto userToUserInputDto(User user) {
		List<RoleDto> rolesDto = user.getRole().stream()
				.map(r -> new RoleDto(r.getId(), r.getDescription())).collect(Collectors.toList());
		
		return new UserDto(user.getId(), user.getName(), user.getEmail(), "******", rolesDto);
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", roles="
				+ roles + "]";
	}
	

}
