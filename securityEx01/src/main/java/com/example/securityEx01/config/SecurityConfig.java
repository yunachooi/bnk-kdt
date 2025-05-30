package com.example.securityEx01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean //패스워드 암호화
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((auth) -> auth
					.requestMatchers("/", "/regMember", "/regist").permitAll()
					.requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()
				);
		
		http.csrf(csrf -> csrf.disable());
		
		http.formLogin((auth) -> auth
					.loginPage("/login")
					.loginProcessingUrl("/loginProc")
					.defaultSuccessUrl("/member/welcome")
					.failureUrl("/fail")
					.permitAll()
				);
		return http.build();
	}	
}
