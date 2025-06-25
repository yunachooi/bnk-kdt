package com.example.ShoppingBasket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingBasket.dto.UserDto;
import com.example.ShoppingBasket.entity.User;
import com.example.ShoppingBasket.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserDto findByUsername(String username) {
		UserDto userDto = new UserDto();
		userDto = convert(userRepository.findByUsername(username));
		return userDto;
	}
	
	private UserDto convert(User user) {
		if(user == null) return null;
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		return userDto;
	}
	
}
