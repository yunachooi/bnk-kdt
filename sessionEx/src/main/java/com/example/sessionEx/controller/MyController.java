package com.example.sessionEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sessionEx.dto.UserDTO;
import com.example.sessionEx.service.UserService;
import com.example.sessionEx.session.UserSession;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserSession userSession;
	
	@GetMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		System.out.println("login From ...");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, RedirectAttributes rttr, HttpSession session, HttpServletResponse response) {
		System.out.println("login...");
		UserDTO result = userService.loginCheck(id, pw);
		if(result != null) {
//			userSession.login(result);
			Cookie cookie = new Cookie("getId", result.getId());
			cookie.setPath("/");
			response.addCookie(cookie);
			return "redirect:/success";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/success")
	public String success(RedirectAttributes rttr, Model model, HttpServletRequest request) {
		System.out.println("success");
		String flag = null;
		
//		if(userSession.isLoggedIn() == true) {
//			model.addAttribute("user", userSession.getLoginUser());
//			return "success";
//		} else {
//			rttr.addFlashAttribute("msg", "로그인이 필요한 요청입니다.");
//			return "redirect:/login";
//		}
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("getId")) {
					System.out.println(cookie.getValue());
					flag = cookie.getValue();
				}
			}
		}
		
		if(flag != null) {
			model.addAttribute("id", flag);
			return "success";
		} else {
			rttr.addFlashAttribute("msg", "로그인이 필요한 요청입니다.");
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(RedirectAttributes rttr, HttpServletResponse response) {
		System.out.println("logout");
//		userSession.logout();
		Cookie cookie = new Cookie("getId", null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		rttr.addFlashAttribute("msg", "방금 로그아웃했습니다.");
		return "redirect:/login";
	}
	
	@GetMapping("/set-cookie")
	public@ResponseBody String setCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("MyCookie", "SoGood!");
		cookie.setPath("/");
		response.addCookie(cookie);
		
		return "cookie set";
	}
	
	@GetMapping("/read-cookie")
	public@ResponseBody String readCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("MyCookie")) {
					System.out.println(cookie.getValue());
				}
			}
		}
		
		return "cookie read";
	}
	
	@GetMapping("/cookie-main")
	public String cookieMain() {
		return "cookieMain";
	}
	
	@GetMapping("/cookie-result")
	public String cookieResult() {
		return "cookieResult";
	}
}
