package com.example.sseBuzz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.sseBuzz.entity.Subscription;
import com.example.sseBuzz.entity.User;
import com.example.sseBuzz.repository.SubscriptionRepository;
import com.example.sseBuzz.repository.UserRepository;
import com.example.sseBuzz.sse.SseEmitters;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/sse")
@Transactional
public class SseController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SseEmitters sseEmitters;

    @PostMapping("/subscribe/author")
    public ResponseEntity<Void> subscribeToAuthor(@RequestBody Map<String, String> request) {
        String subscriberName = request.get("subscriber");
        String targetName = request.get("target");

        User subscriber = userRepository.findByUsername(subscriberName);
        User targetAuthor = userRepository.findByUsername(targetName);

        if (subscriber == null || targetAuthor == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean alreadySubscribed = subscriptionRepository.existsBySubscriberAndTargetAuthor(subscriber, targetAuthor);
        if (alreadySubscribed) {
            return ResponseEntity.ok().build();
        }

        Subscription subscription = new Subscription();
        subscription.setSubscriber(subscriber);
        subscription.setTargetAuthor(targetAuthor);

        subscriptionRepository.save(subscription);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/connect/{username}")
    public SseEmitter connect(@PathVariable("username") String username) {
        try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new RuntimeException("User not found: " + username);
            }

            SseEmitter emitter = new SseEmitter(30 * 60 * 1000L);
            sseEmitters.add(user.getId(), emitter);
            System.out.println("[SSE 연결] 사용자 ID: " + user.getId() + ", 이름: " + user.getUsername());

            emitter.onCompletion(() -> sseEmitters.remove(user.getId()));
            emitter.onTimeout(() -> sseEmitters.remove(user.getId()));

            return emitter;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
