package com.example.ShoppingBasket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingBasket.dto.ProductDto;
import com.example.ShoppingBasket.entity.Product;
import com.example.ShoppingBasket.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<ProductDto> getAllProducts() {
		List<Product> list = productRepository.findAll();
		
		return list.stream()
                .map(product -> {
                    ProductDto dto = new ProductDto();
                    dto.setProductNo(product.getProductNo());
                    dto.setProductName(product.getProductName());
                    dto.setProductPrice(String.valueOf(product.getProductPrice()));
                    dto.setProductStock(String.valueOf(product.getProductStock()));
                    return dto;
                })
                .collect(Collectors.toList());
	}
}
