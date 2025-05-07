package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@RequestMapping("/req1")
	public @ResponseBody String req1() {
		System.out.println("req1...");
		return "req1";
	}
}
