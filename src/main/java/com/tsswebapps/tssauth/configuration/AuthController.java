package com.tsswebapps.tssauth.configuration;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.tssauth.dto.UserAuth;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@PostMapping
	public ResponseEntity<?> onAuth(@RequestBody @Valid UserAuth user){		
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		return ResponseEntity.ok().build();
	}
}
