package com.tsswebapps.tssauth.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
public class Token {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String access_token;
	
	@Column(length = 20)
	private String token_type;
	
	@Column(nullable = false)
	private Integer expires_in;	
	
	@OneToOne
	@JoinColumn(referencedColumnName = "id", name = "user_id", unique = true)
	private User user;
	
	public Token(Long id, String access_token, String token_type, Integer expires_in, User user) {
		this.id = id;
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Token() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public int hashCode() {
		return Objects.hash(access_token, expires_in, id, token_type, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		return Objects.equals(access_token, other.access_token) && Objects.equals(expires_in, other.expires_in)
				&& Objects.equals(id, other.id) && Objects.equals(token_type, other.token_type)
				&& Objects.equals(user, other.user);
	}
	
}
