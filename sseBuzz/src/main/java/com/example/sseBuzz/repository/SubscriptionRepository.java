package com.example.sseBuzz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sseBuzz.entity.Subscription;
import com.example.sseBuzz.entity.User;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	List<Subscription> findAllByTargetAuthor(User author);
	boolean existsBySubscriberAndTargetAuthor(User subscriber, User targetAuthor);
}
