package com.tsswebapps.tssauth.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.tssauth.domain.model.User;
import com.tsswebapps.tssauth.domain.repository.UserRepository;
import com.tsswebapps.tssauth.dto.UserInputDto;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserInputDto saveUser(UserInputDto userDto) {
		User user = repository.save(User.userInputDtoToUser(userDto));				
		return UserInputDto.userToUserInputDto(user);
	}
	
	
}
