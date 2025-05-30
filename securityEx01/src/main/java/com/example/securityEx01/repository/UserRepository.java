package com.example.securityEx01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityEx01.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
