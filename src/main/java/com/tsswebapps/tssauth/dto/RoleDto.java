package com.tsswebapps.tssauth.dto;

import com.tsswebapps.tssauth.domain.model.Role;

public class RoleDto {
	private Long id;
	private String description;

	public RoleDto() {
	}

	public RoleDto(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public static RoleDto roleToRoleDto (Role role) {
		return new RoleDto(role.getId(), role.getDescription());
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", description=" + description + "]";
	}

}
