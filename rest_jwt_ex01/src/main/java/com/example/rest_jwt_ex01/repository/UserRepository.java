package com.example.rest_jwt_ex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest_jwt_ex01.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
