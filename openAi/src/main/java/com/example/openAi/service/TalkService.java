package com.example.openAi.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalkService {
	@Autowired
	private ChatClient ChatClient;
	
	public String talk(String message) {
		return ChatClient.prompt() //프롬프트 생성
						 .user(message) //사용자 질문
						 .call() //ai 호출
						 .content(); //ai 응답 문자열
	}
}
