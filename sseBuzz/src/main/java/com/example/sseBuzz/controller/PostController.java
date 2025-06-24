package com.example.sseBuzz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sseBuzz.entity.Post;
import com.example.sseBuzz.entity.Subscription;
import com.example.sseBuzz.entity.User;
import com.example.sseBuzz.repository.PostRepository;
import com.example.sseBuzz.repository.SubscriptionRepository;
import com.example.sseBuzz.repository.UserRepository;
import com.example.sseBuzz.sse.SseEmitters;

@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
    private PostRepository postRepository;
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private SubscriptionRepository subscriptionRepository;
	@Autowired
    private SseEmitters sseEmitters;

    public PostController(PostRepository postRepository, UserRepository userRepository,
                          SubscriptionRepository subscriptionRepository, SseEmitters sseEmitters) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.sseEmitters = sseEmitters;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createPost(@RequestParam("authorName") String authorName,
                                           @RequestBody Map<String, String> body) {
        User author = userRepository.findByUsername(authorName);
        String content = body.get("content");

        Post post = new Post();
        post.setAuthor(author);
        post.setContent(content);
        postRepository.save(post);

        List<Subscription> subscriptions = subscriptionRepository.findAllByTargetAuthor(author);
        System.out.println("[디버그] 구독자 리스트: " + subscriptions);
        
        for (Subscription sub : subscriptions) {
            sseEmitters.sendTo(sub.getSubscriber().getId(), author.getUsername() + "님이 글을 작성했습니다.");
        }

        return ResponseEntity.ok().build();
    }

}
