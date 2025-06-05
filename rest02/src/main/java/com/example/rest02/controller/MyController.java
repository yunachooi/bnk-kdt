package com.example.rest02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/")
	public @ResponseBody String root() {
		return "REST API 두번째 실습";
	}
}
