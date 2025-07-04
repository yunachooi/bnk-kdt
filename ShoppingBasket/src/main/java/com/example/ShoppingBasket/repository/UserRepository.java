package com.example.ShoppingBasket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShoppingBasket.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

}
