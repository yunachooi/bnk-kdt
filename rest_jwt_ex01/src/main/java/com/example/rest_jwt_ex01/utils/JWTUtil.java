package com.example.rest_jwt_ex01.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JWTUtil {
	private SecretKey secretKey;
	
	public JWTUtil(@Value("${spring.jwt.secret}")String secret) {
		this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
				Jwts.SIG.HS256.key().build().getAlgorithm()); //암호화
		
		System.out.println("SecretKey: " + secretKey.toString()+", Algritm: "+ secretKey.getAlgorithm());
	}
	
	//토큰에서 사용자 정보 추출
	public String getUsername(String token) {
		String username = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
				.getPayload().get("username", String.class);
		
		return username;
	}
	//이메일 추출하기
	public String getEmail(String token) {
		String email = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
				.get("email",String.class);
		return email;
	}
	
	//로그인 성공시 토큰 생성 : 시간 계산 - 1000(1초) * 60 * 3L
	public String createJwt(String username, String email, Long expirationMs) { //JSON이 문자열이라서 String
		String token = Jwts.builder() //메서드 체이닝
						.claim("username", username) //사용자 정보 추가
						.claim("email", email) //이메일 정보 추가
						.issuedAt(new Date(System.currentTimeMillis()))
						.expiration(new Date(System.currentTimeMillis()+ expirationMs)) //유효시간
						.signWith(secretKey)
						.compact();
		return token;
	}
}

