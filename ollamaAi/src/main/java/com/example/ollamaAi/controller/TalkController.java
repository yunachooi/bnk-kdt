package com.example.ollamaAi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ollamaAi.service.TalkService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
	
	@PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> request) {
        try {
            String message = request.get("message");
            System.out.println("received message body : " + message);
            
            String aiResponse = talkService.talk(message);
            
            Map<String, String> response = new HashMap<>();
            response.put("response", aiResponse);
            
            return response;
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "서버 오류가 발생했습니다.");
            return errorResponse;
        }
    }
}
