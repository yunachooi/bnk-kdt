package com.example.ShoppingBasket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingBasket.entity.Basket;
import com.example.ShoppingBasket.entity.Product;
import com.example.ShoppingBasket.entity.User;
import com.example.ShoppingBasket.repository.BasketRepository;
import com.example.ShoppingBasket.repository.ProductRepository;
import com.example.ShoppingBasket.repository.UserRepository;

@Service
public class BasketService {
	@Autowired
	private BasketRepository basketRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	public void registBasket(String username, int productNo, int productCount) {
		User user = userRepository.findById(username)
				.orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

		Product product = productRepository.findById(productNo)
				.orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

		Basket basket = new Basket();
		basket.setUser(user);
		basket.setProduct(product);
		basket.setProductCount(productCount);

		basketRepository.save(basket);
	}

}
