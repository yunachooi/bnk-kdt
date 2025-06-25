package com.example.ShoppingBasket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ShoppingBasket.dto.UserDto;
import com.example.ShoppingBasket.service.ProductService;
import com.example.ShoppingBasket.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("productList", productService.getAllProducts());
		return "index";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@GetMapping("/basket")
	public String basket(HttpSession session) {
		UserDto userDto = (UserDto) session.getAttribute("user");
		if (userDto == null) {
			return "login";
		} else {
			return "basket";
		}
	}

	@PostMapping("/login")
	public String login(UserDto userDto, HttpSession session) {
		UserDto userInfo = userService.findByUsername(userDto.getUsername());

		if (userInfo != null && userInfo.getPassword().equals(userDto.getPassword())) {
			session.setAttribute("user", userInfo);
			return "redirect:/";
		} else {
			return "login";
		}
	}
}
