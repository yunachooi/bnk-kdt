package com.example.securityEx02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityEx02.dto.UserDto;
import com.example.securityEx02.entity.User;
import com.example.securityEx02.service.JoinService;

import lombok.extern.slf4j.Slf4j;

@Controller
public class JoinController {
	private JoinService joinService;
	public JoinController(JoinService joinService) {
		this.joinService = joinService;
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "registForm";
	}
	
	@PostMapping("/registProc")
	public String regist(UserDto userDto) {
		User result = joinService.regist(userDto);
		System.out.println(result);
		if (result != null) {
			return "redirect:/login";
		}
		return "redirect:/regist";
	}
}
