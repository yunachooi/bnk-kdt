package com.example.rest_jwt_ex01.controller;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_jwt_ex01.dto.LoginDto;
import com.example.rest_jwt_ex01.entity.User;
import com.example.rest_jwt_ex01.service.UserService;
import com.example.rest_jwt_ex01.utils.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JwtTestController {
	@Value("${spring.jwt.secret}")
	private String secretkey;
	
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto, 
				//HttpServletRequest result
				//요청(세션을 사용하지 않아서 필요없음 
				HttpServletResponse response) {	//응답
		//로그인 성공
		if(userService.loginCheck(loginDto.getUsername(), loginDto.getPassword())) {
			User user = new User();
			
			user = userService.getUserInfo(loginDto.getUsername());
			
			String token = makeJwt(loginDto.getUsername(), user.getEmail());
			String refreshToken = makeFreshJwt(loginDto.getUsername(), user.getEmail());
			
			response.setHeader("USER-AUTH", token);
			response.setHeader("REFRESH-AUTH", refreshToken);
			
			return "토큰이 발급되었습니다.";
		}
		
		return "아이디 또는 비밀번호가 일치하지 않습니다.";
	}

	private String makeJwt(String username, String email) {
		String jwt = jwtUtil.createJwt(username, email, 1000 * 60 * 3L);
		String token = "Bearer " + jwt;
		
		return token;
	}
	
	private String makeFreshJwt(String username, String email) {
		String jwt = jwtUtil.createRefreshJwt(username, email, 2000 * 60 * 3L);
		String token = "Bearer " + jwt;
		
		return token;
	}
	
	@GetMapping("/user")
	public String getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		String userAuth = request.getHeader("USER-AUTH");
		if(userAuth == null || userAuth.isEmpty()) {
			return "Bad";
		}
		try{
			String jwt = userAuth.split(" ")[2];
			String username = jwtUtil.getUsername(jwt);
			String email = jwtUtil.getEmail(jwt);
			
			SecretKey key = Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8));
			JwtParser parser = Jwts.parser()
					.verifyWith(key)
					.build();
			Jws<Claims> jws = parser.parseSignedClaims(jwt); //서명
			Claims claims = jws.getPayload();
			
			Date iat = claims.getIssuedAt();
			Date exp = claims.getExpiration();
			
			System.out.println(iat);
			System.out.println(exp);
			
			return "현재 접속 중인 사용자: " + username + ", " + email;
		} catch(Exception e) {
			System.err.println(e.getMessage());
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401 error code
			
			return "토큰이 없거나 만료됨";
		}
	}
}
