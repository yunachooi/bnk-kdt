package com.example.test05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class SessionController {
	@GetMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@GetMapping("/sessionTest")
	public String sessionTest(HttpSession session, RedirectAttributes rttr) {
	    System.out.println("sessionTest...");
	    
	    if (session.getAttribute("id") == null) {
	        rttr.addFlashAttribute("errMsg", "회원전용 페이지입니다. 로그인이 필요합니다.");
	        return "redirect:/login";
	    }
	    rttr.addFlashAttribute("errMsg", "로그인되었습니다.");
	    return "sessionTest";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		System.out.println("loginForm...");
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpServletRequest request, Model model) {
		System.out.println("login...");
		String setId = "id01";
		String setPw = "1234";
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		
		if(setId.equals(id) && setPw.equals(pw)) {
			return "sessionTest";
		} else {
			model.addAttribute("error", "아이디 또는 비밀번호를 확인하세요.");
			return "loginForm";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("logout...");
		request.getSession().invalidate();
    	
    	return "redirect:/login";
	}
	
	@PostMapping("/extend-session")
	public void extendSession(HttpSession session) {
		session.setMaxInactiveInterval(60);
	}
}
