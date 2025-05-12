package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.MemberDTO;

@Controller
public class MyController {
	/* @Controller 시 요청을 처리할 수 있는 Class */

	@RequestMapping("/")
	public @ResponseBody String root() {
		/* return 용도 1 : 문자열 데이터 @ResponseBody */
		return "SpringBoot Start!";
	}

	@GetMapping("/test")
	public String test() {
		/* return 용도 2 : 페이지 이름 */
		return "test"; // 요청 주소와 페이지명이 일치할 경우에는 생략 가능
	}

	/* 파라미터를 처리하는 기존 방식 */
//	@GetMapping("/p1")
//	public String p1(HttpServletRequest request, Model model) {
//		String name = request.getParameter("name");
//		model.addAttribute("name", name);
//		
//		return "p1";
//	}

	/* 파라미터를 처리하는 선호하지 않는 방식 */
//	@GetMapping("/p1")
//	public String p1() {
//		
//		return "p1";
//	}

//	/*파라미터를 처리하는 Model 방식*/
//	@GetMapping("/p1")
//	public String p1(HttpServletRequest request, Model model) {
//		String name = request.getParameter("name");
//		model.addAttribute("name", name);
//		
//		return "p1";
//	}

	/* 파라미터를 처리하는 새로운 방식 */
//	@GetMapping("/p1")
//	public String p1(@RequestParam("name")String name, Model model) {
//		model.addAttribute("name", name);
//		model.addAttribute("age", 23);
//		
//		return "p1";
//	}

	
//	@PostMapping("/p1")
//	public String p1(MemberDTO memberDTO, Model model) {
//		List<MemberDTO> list = new ArrayList<>();
//
//		list.add(memberDTO);
//		model.addAttribute("list", list);
//
//		return "p1";
//	}
	
	/*커맨드객체는 기본생성자가 필요*/
	@GetMapping("/p1")
	public String p1(MemberDTO memberDTO, Model model) {
		List<MemberDTO> list = new ArrayList<>();

		list.add(memberDTO);
		model.addAttribute("list", list);

		return "p1";
	}
	
	/*PathVariable*/
	@GetMapping("/p3/{id}/{pw}")
	public String p3(@PathVariable("id")String id, @PathVariable("pw")String pw, Model model) {
		System.out.println("p3..." + id + "..." + pw);
		
		model.addAttribute(id);
		model.addAttribute(pw);
		
		return "p3";
	}
	
}
