package com.tsswebapps.tssauth.infra.service.generationToken;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tsswebapps.tssauth.dto.TokenDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthTokenJjwt implements AuthToken {
	
	@Value("${jwt.secret}")
	private String secretJwt;

	@Override
	public TokenDto newToken(String issuer, String subject, String secret, Long expires_in) {
		
		Date toDay = new Date();
		Date expiresDate = new Date( toDay.getTime() + expires_in);
		
		//Key key = new SecretKeySpec( this.secretJwt.getBytes() , SignatureAlgorithm.HS256.getJcaName());
		
		String accessToken = Jwts.builder()
			.setIssuer(issuer)
			.setSubject(subject)
			.setIssuedAt(toDay)
			.setExpiration(expiresDate)
			.signWith(getHmacKey())
			.compact();
		
		return new TokenDto(accessToken, "Bearer", expires_in);
	}

	@Override
	public boolean isValid(String tokenHeader) {		
		try {
			Jwts.parserBuilder()
			.setSigningKey(getHmacKey())
			.build()
			.parseClaimsJws(tokenHeader);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Long getUserIdToken(String tokenHeader) {
		Claims body = Jwts.parserBuilder()
		.setSigningKey(getHmacKey())
		.build()
		.parseClaimsJws(tokenHeader)
		.getBody();

		return Long.parseLong(body.getSubject());
	}

	private Key getHmacKey() {
		return new SecretKeySpec(this.secretJwt.getBytes(), 
	    		SignatureAlgorithm.HS256.getJcaName());
	}

}
