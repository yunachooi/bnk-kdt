package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired  //인스턴스 자동 할당, IOC
	private MemberDAO memberDao;
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	/*수정 사전작업*/
	@GetMapping("/beforeUpdate")
	public String beforeupdate(@RequestParam("id")String id, Model model) {
		System.out.println("beforeUpdate...");
		
		MemberDTO member= memberDao.viewMember(id);
		model.addAttribute("member", member);
		
		return "updateInfo";
	}
	
	/*수정*/ 
	@PostMapping("/updateInfo")
	public String updateinfo(MemberDTO member) {
		System.out.println("updateinfo...");
		
		memberDao.updateMember(member);
		
		return "index";
	}
	
	/*삽입*/
	@PostMapping("/write")
	public String write(MemberDTO member) {
		System.out.println("write...");
		
		memberDao.writeMember(member);
		System.out.println("success!");
		
		return "index";
	}
	
	/*전체조회*/
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list...");
		
		List<MemberDTO> list = new ArrayList<>();
		list =  memberDao.list();
		model.addAttribute("list",list);
		
		return "list";
	}
	
	/*특정 값 조회*/
	@GetMapping("/detail")
	public String list(@RequestParam("id")String id ,Model model) {
		System.out.println("detail list...");
		
		MemberDTO member = memberDao.viewMember(id);
		model.addAttribute("member",member);
		
		return "detail";
	}
	
}
