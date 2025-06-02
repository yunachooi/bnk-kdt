package com.example.securityEx02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String loginForm(@RequestParam(value = "logout", required = false) String logout,
							@RequestParam(value = "needLogin", required = false) String needLogin,
							Model model) {
		if(logout != null) {
			model.addAttribute("msg", "로그아웃 되었어요...");
		}
		if(needLogin != null) {
			model.addAttribute("msg", "로그아웃 되었어요...");
		}
		return "loginForm";
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
}
