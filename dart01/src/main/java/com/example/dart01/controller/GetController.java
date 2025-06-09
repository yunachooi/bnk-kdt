package com.example.dart01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dart01.dto.Post;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class GetController {
	@GetMapping("/post/{pno}")
	public ResponseEntity<Post> getPost(@PathVariable("pno") int pno) {
		Post post = new Post();
		post.setPno(1);
		post.setTitle("New Get...");
		post.setBody("New Get Body...");
		
		List<Post> list = new ArrayList<>();
		list.add(post);
		
		for (Post p : list) {
            if (p.getPno() == pno) {
                return ResponseEntity.ok(p);
            }
        }
		
		return ResponseEntity.notFound().build();
	}
}
