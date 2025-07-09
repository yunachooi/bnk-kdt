package com.example.openAi.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
	@Bean
	ChatClient openaliChatClient(OpenAiChatModel openAiChatModel) {
		return ChatClient.builder(openAiChatModel).build();
	}
}
