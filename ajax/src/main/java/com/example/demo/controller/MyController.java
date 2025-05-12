package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/* return 활용
1. view 지정
2. Data 전송 (@RespenseBody를 사용)
 */
public class MyController {
	@RequestMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
}
