package com.tsswebapps.tssauth.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tsswebapps.tssauth.dto.UserDto;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(length = 100)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String secret;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Role> role = new ArrayList<>();
	
	public User() {}
	
	public User(Long id, String email, String name, String password, String secret, List<Role> role) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.secret = secret;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public List<Role> getRole() {
		return Collections.unmodifiableList(this.role);
	}

	public void setRole(Role role) {
		addRole(role);
	}
	
	private void addRole(Role role) {
		this.role.add(role);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role);
	}
	
	public static User userInputDtoToUser(UserDto user) {
		List<Role> roles = user.getRolesDto().stream()
				.map(r -> new Role(r.getId(), r.getDescription()))
				.collect(Collectors.toList());
		
		return new User(user.getId(), user.getEmail(), user.getName(), user.getPassword(), getSecretKey(), roles);
	}
	
	public static String getSecretKey() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
