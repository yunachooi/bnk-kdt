package com.example.rest_jwt_ex01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest_jwt_ex01.entity.User;
import com.example.rest_jwt_ex01.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Boolean loginCheck(String username, String password) {
		System.out.println("로그인 체크 : " + username + ", " + password);
		User user = new User();
		user = userRepository.findByUsername(username);
		System.out.println("유저 정보: " + user);
		if(user != null && user.getPassword().equals(password)) {
			System.out.println("로그인 성공");
			return true;
		} else {
			return false;
		}
	}
	
	public User getUserInfo(String username) {
		return userRepository.findByUsername(username);
	}
}
