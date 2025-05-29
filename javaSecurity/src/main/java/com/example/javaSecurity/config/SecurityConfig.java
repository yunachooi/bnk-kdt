package com.example.javaSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //@설정
@EnableWebSecurity
public class SecurityConfig {
	@Bean //메서드의 반환되는 자료가 Bean으로 등록 (controller, service, repository : 컨트롤러 서비스 리포지토리 제외)
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/").permitAll() //root 경로는 모두에게 개방
//				.anyRequest().permitAll() //모두 개방
				.anyRequest().authenticated()
				);
		
//		http.formLogin(Customizer.withDefaults());
//		http.httpBasic(Customizer.withDefaults());
		
		http.formLogin(auth -> auth
				.loginPage("/login")
				.loginProcessingUrl("/loginProc")
				.defaultSuccessUrl("/welcome")
				.permitAll()
				);
		
		http.csrf(csrf -> csrf.disable());
		http.logout(Customizer.withDefaults());
		
		return http.build();
	}

}
