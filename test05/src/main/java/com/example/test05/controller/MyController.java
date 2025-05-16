package com.example.test05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test05.dto.UserDTO;

@Controller
public class MyController {
	@GetMapping("/jqueryTest")
	public String jquery() {
		return "jqueryTest";
	}
	
	@GetMapping("/api/data")
	public@ResponseBody String data() {
		return "Hello";
	}
	
	@PostMapping("/api/post")
	public@ResponseBody String post(@RequestBody UserDTO user) {
		String name = user.getName();
		int age = user.getAge();
		return "name: " + name + ", age: " + age ;
	}
}
