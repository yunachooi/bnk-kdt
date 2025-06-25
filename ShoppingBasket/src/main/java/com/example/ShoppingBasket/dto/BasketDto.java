package com.example.ShoppingBasket.dto;

import lombok.Data;

@Data
public class BasketDto {
	private int basketNo;
	private String username;
	private int productNo;
	private int productCount;
}
