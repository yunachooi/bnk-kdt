package com.example.openAi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.openAi.service.TalkService;

@RestController
@RequestMapping("/ai")
public class TalkController {
	@Autowired
	private TalkService talkService;
	
	@GetMapping("/talk")
	public String talk(@RequestParam("message") String message) {
		System.out.println("recived message param : " + message);
		return talkService.talk(message);
	}
}
