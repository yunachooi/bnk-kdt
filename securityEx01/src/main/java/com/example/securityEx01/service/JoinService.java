package com.example.securityEx01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securityEx01.dto.UserDto;
import com.example.securityEx01.entity.User;
import com.example.securityEx01.repository.UserRepository;

@Service
public class JoinService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User regist(UserDto userDto) {
        String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encodedPassword);
        user.setName(userDto.getName());

        if ("admin".equals(userDto.getUsername())) {
            user.setRole("ROLE_ADMIN");
        } else {
            user.setRole("ROLE_MEMBER");
        }

        return userRepository.save(user);
    }
}
