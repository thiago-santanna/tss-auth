package com.tsswebapps.tssauth.infra.service.generationToken;

import com.tsswebapps.tssauth.dto.TokenDto;


public interface AuthToken {
	TokenDto newToken( String issuer, String subject, String secret, Long expires_in);
}
