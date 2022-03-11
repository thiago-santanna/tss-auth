package com.tsswebapps.tssauth.dto;

import java.util.Objects;

import com.tsswebapps.tssauth.domain.model.Token;
import com.tsswebapps.tssauth.domain.model.User;

public class TokenDto {

	private String access_token;

	private String token_type;

	private Long expires_in;

	public TokenDto(String access_token, String token_type, Long expires_in) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
	}

	public TokenDto() {
	}

	public String getAccess_token() {
		return access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	@Override
	public String toString() {
		return "TokenDto [access_token=" + access_token + ", token_type=" + token_type + ", expires_in=" + expires_in
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(access_token, expires_in, token_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenDto other = (TokenDto) obj;
		return Objects.equals(access_token, other.access_token) && Objects.equals(expires_in, other.expires_in)
				&& Objects.equals(token_type, other.token_type);
	}
	
	public static Token tokenDtoToToken(TokenDto tokenDto, User user) {
		return new Token(tokenDto.getAccess_token(), tokenDto.getToken_type(), tokenDto.getExpires_in(), user);
	}

}
