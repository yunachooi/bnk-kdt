package com.example.sseBuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sseBuzz.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
