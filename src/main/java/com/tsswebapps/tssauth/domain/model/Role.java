package com.tsswebapps.tssauth.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.tsswebapps.tssauth.dto.RoleDto;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(length = 6)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id);
	}
	
	public Role() {
	}
	
	public Role(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public static Role roleDtoToRole(RoleDto roleDto) {
		return new Role(roleDto.getId(), roleDto.getDescription());
	}

	@Override
	public String getAuthority() {
		return this.description;
	}

}
