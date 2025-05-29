package com.example.javaSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	@GetMapping("/")
	public String root(Model model) {
		log.info("root...");
		model.addAttribute("msg", "Hi ~ Security~~");
		return "index";
	}

	@GetMapping("/p1")
	public String p1() {
		return "p1";
	}
	
	@GetMapping("/p2")
	public String p2() {
		return "p2";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
}
