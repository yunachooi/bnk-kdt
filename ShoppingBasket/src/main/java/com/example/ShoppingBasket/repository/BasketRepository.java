package com.example.ShoppingBasket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShoppingBasket.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

}
