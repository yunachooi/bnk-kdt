package com.example.rest_jwt_ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
