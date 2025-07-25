package com.example.sseBuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sseBuzz.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
