package com.example.ShoppingBasket.dto;

import lombok.Data;

@Data
public class ProductDto {
	private int productNo;
	private String productName;
	private String productPrice;
	private String productStock;
}
