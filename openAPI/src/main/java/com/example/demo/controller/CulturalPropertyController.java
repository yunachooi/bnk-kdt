package com.example.demo.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.api.ApiExplorer;

@Controller
public class CulturalPropertyController {
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@GetMapping("/getList")
	public @ResponseBody String getList(@RequestParam("page") int page) {
		System.out.println("list...");
		ApiExplorer ae = new ApiExplorer();
		
		String content = "로딩 실패...";
		
		try {
			content = ae.getJson(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    return content;
	}
	
}
