package com.example.ShoppingBasket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShoppingBasket.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
