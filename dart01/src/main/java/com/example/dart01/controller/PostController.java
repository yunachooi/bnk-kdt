package com.example.dart01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dart01.dto.Post;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PostController {
	@PostMapping("/post")
	public ResponseEntity<Post> postPost(@RequestBody Post post) {
		System.out.println("Post..." + post);
		
		if(post != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(post);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(post);
	}
}
