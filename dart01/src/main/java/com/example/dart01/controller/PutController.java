package com.example.dart01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dart01.dto.Post;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PutController {

	@PutMapping("/put")
	public ResponseEntity<Post> putPost(@RequestBody Post post) {
		System.out.println("Put..." + post);
		
		post.setTitle(post.getTitle());
		post.setBody(post.getBody());
		
		if(post != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(post);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(post);
	}
}
