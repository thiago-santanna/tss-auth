package com.tsswebapps.tssauth.infra.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.tssauth.domain.model.User;
import com.tsswebapps.tssauth.domain.repository.UserRepository;
import com.tsswebapps.tssauth.dto.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public UserDto saveUser(UserDto userDto) {
		User user = repository.save(User.userInputDtoToUser(userDto));
		System.out.println(user);
		return UserDto.userToUserInputDto(user);
	}
	
	
}
