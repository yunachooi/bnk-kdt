package com.example.ai_rag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RagController {
	@Autowired
	private VectorStore vectorStore;
	@Autowired
	private ChatClient chatClient;
	@Autowired
	private ChatMemory chatMemory;
	
	private String prompt = """
				You are an asistant for question-answering tasks.
				Use the following pieces of retrieved context to answer the question.
				If you don't know the answer, just say that you don't know.
				Answer in korean.
				
				#Question:
				{input}
				
				#Context:
				{documents}
				
				#Answer:
			""";
	
	@GetMapping("/api/answer")
	public String reqAnswer(@RequestParam("question") String question) {
		PromptTemplate template = new PromptTemplate(prompt);
		
		Map<String, Object> promptParameters = new HashMap<>();
		promptParameters.put("input", question);
		promptParameters.put("documents", findSimillarData(question));
		
		Prompt str = template.create(promptParameters);
		
		return chatClient.prompt(str)
					.advisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
					.call()
					.content();

	}

	private String findSimillarData(String question) {
		List<Document> documents = vectorStore.similaritySearch(
				SearchRequest.builder()
					.query(question) //검색 질문
					.topK(2) //상위 2개 반환
					.similarityThreshold(0.7) //유사도 0.7 이상만 반환
					.build()
				);
		return documents.stream()
				.map(document -> document.getText()) //각 Document에서 텍스트 추출
				.collect(Collectors.joining()); //모든 텍스트를 하나로 연결
	}
}
