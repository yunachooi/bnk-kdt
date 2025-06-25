package com.example.ShoppingBasket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ShoppingBasket.dto.UserDto;
import com.example.ShoppingBasket.service.BasketService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/basket")
public class BasketController {
	@Autowired
	private BasketService basketService;
	
	@PostMapping("/add")
	public @ResponseBody String addToBasket(@RequestParam("productNo") int productNo, HttpSession session) {
		UserDto userDto = (UserDto) session.getAttribute("user");
		if(userDto == null) {
		    return "로그인이 필요합니다.";
		}

		String username = userDto.getUsername();
		basketService.registBasket(username, productNo, 1);


	    return "장바구니에 상품이 추가되었습니다.";
	}

}
