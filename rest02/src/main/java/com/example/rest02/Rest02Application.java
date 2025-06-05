package com.example.rest02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Rest02Application {

	public static void main(String[] args) {
		SpringApplication.run(Rest02Application.class, args);
	}
}
