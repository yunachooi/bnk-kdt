package com.example.securityEx02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityEx02.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);
}
