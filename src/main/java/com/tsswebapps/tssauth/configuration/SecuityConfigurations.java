package com.tsswebapps.tssauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tsswebapps.finance.api.config.AuthenticatedService;

@Configuration
@EnableWebSecurity
public class SecuityConfigurations extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticatedService authenticatedService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(authenticatedService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/usuario/cadastro").permitAll()
				.antMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
				.antMatchers("/", "/js/**", "/css/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
			.csrf()
				.disable();
	}
}
