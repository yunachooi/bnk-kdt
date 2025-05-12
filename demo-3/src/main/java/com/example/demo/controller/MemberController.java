package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO memberDao;
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<MemberDTO> getMemberList() {
	    return memberDao.list();
	}


	/*id를 클릭하여 상세 조회*/
	@GetMapping("/detail")
	@ResponseBody
	public MemberDTO detail(@RequestParam("id") String id) {
	    System.out.println("detail...");
	    return memberDao.detail(id);
	}
	
	/*회원등록 페이지로 연결*/
	@GetMapping("/registForm")
	public String registForm() {
		System.out.println("regist Form...");
		
		return "registForm";
	}
	
	/*회원등록 후 DB 처리*/
	@PostMapping("/writeMember")
	public String writeMember(MemberDTO memberDTO, Model model) {
		System.out.println("registResult...");
		
		memberDTO.setGrade("B");
		model.addAttribute("member", memberDTO);
		
		int result = memberDao.writerMember(memberDTO);
		
		return "index";
	}
	
	/*회원탈퇴*/
	@GetMapping("/remove")
	public @ResponseBody String remove(@RequestParam("id") String id) {
		System.out.print("remove...");
		
		int result = memberDao.remove(id);
		
		if(result == 1)
			return "1";
		else
			return "0";
	}
	
	/*아이디 중복 검사*/
	@PostMapping("/idCheck")
	public @ResponseBody String idCheck(@RequestParam("id") String id) {
		System.out.println("idCheck..." + id);
		
		int result = memberDao.idCheck(id);
		
		if(result == 1) {
			return "중복된 아이디입니다.";
		} else {
			return "사용가능한 아이디입니다.";
		}
	}
	
}