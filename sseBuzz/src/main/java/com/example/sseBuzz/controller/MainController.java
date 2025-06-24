package com.example.sseBuzz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sseBuzz.entity.Subscription;
import com.example.sseBuzz.entity.User;
import com.example.sseBuzz.repository.SubscriptionRepository;
import com.example.sseBuzz.repository.UserRepository;

@Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}

	@PostMapping("/subscribe/author")
	public ResponseEntity<Void> subscribeToAuthor(@RequestBody Map<String, String> req) {
	    String subscriberName = req.get("subscriber");
	    String targetName = req.get("target");

	    User subscriber = userRepository.findByUsername(subscriberName);
	    User target = userRepository.findByUsername(targetName);

	    Subscription subscription = new Subscription();
	    subscription.setSubscriber(subscriber);
	    subscription.setTargetAuthor(target);
	    subscriptionRepository.save(subscription);

	    return ResponseEntity.ok().build();
	}

}
