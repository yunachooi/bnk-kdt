package com.example.securityEx02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {
	@GetMapping("/adminpage")
	public String adminpage() {
		return "/admin/adminpage";
	}
}
