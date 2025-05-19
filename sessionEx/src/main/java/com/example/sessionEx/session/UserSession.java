package com.example.sessionEx.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.sessionEx.dto.UserDTO;

@Component
@SessionScope
public class UserSession {
	//로그인 사용자 정보 저장용 객체
	private UserDTO loginUser; 
	
	//로그인처리
	public void login(UserDTO user) {
		loginUser = user;
	}
	
	//로그아웃처리
	public void logout() {
		loginUser = null;
	}
	
	//현재 로그인 여부 확인
	public boolean isLoggedIn() {
		return loginUser != null;
	}
	
	//로그인 사용자 정보 조회
	public UserDTO getLoginUser() {
		return loginUser;
	}
}
