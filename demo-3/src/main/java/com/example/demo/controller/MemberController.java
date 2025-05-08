package com.example.demo.controller;

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

	@Autowired
	private MemberDAO memberDao;
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root..........");
		return "index";
	}
	
	/*list page로 연결*/
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list...");
		
		List<MemberDTO> list = memberDao.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	/*id를 클릭하여 상세 조회*/
	@GetMapping("/detail")
	public String detail(@RequestParam("id")String id, Model model) {
		System.out.println("detail...");
		
		MemberDTO member = memberDao.detail(id);
		model.addAttribute("member", member);
		
		return "detail";
	}
	
	/* ccc인 사람 정보 보여주기 */
	@GetMapping("/viewMember")
	public String viewMember(Model model) {
		System.out.println("view member...");
		
		MemberDTO member1 = memberDao.viewMember("ccc");
		model.addAttribute("member1", member1);
		
		return "viewMember";
	}
	
	/*회원등록 페이지로 연결*/
	@GetMapping("/writeForm")
	public String writeForm() {
		System.out.println("write form...");
		
		return "writeForm";
	}
	
	/*회원등록 후 DB 처리*/
	@PostMapping("/writeMember")
	public String writeMember(MemberDTO memberDTO, Model model) {
		System.out.println("write to db...");
		
		memberDTO.setGrade("B");
		model.addAttribute("member", memberDTO);
		
		int result = memberDao.writerMember(memberDTO);
		
		if(result == 1)
			return "writeResult";
		else
			return "fault";
	}
	
	/*회원탈퇴*/
	@GetMapping("/remove")
	public String remove(@RequestParam("id")String id) {
		System.out.print("remove...");
		
		int result = memberDao.remove(id);
		
		if(result == 1)
			return "index";
		else
			return "fault";
	}
	
}