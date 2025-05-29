package com.example.jpaEx01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jpaEx01.entity.MemberEntity;
import com.example.jpaEx01.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/")
	public String root() {
		log.info("root...");
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list...");
		List<MemberEntity> list = memberRepository.findAll();
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		log.info("regist Form...");
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(MemberEntity memberEntity, RedirectAttributes rttr) {
		log.info("regist...");
		
		memberEntity.setRole("MEMBER");
		
		MemberEntity m = memberRepository.save(memberEntity);
		rttr.addFlashAttribute("member", m);
		
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String success() {
		log.info("success");
		return "success";
	}
	
	@GetMapping("/detail") //방법1
	public String detail(@RequestParam("username") String username, Model model){
		log.info("detail");
		
		//Optional : null 안정성 확보
		Optional<MemberEntity> result = memberRepository.findById(username); //@Id 속성
		MemberEntity m = result.get();
		
		model.addAttribute("member", m);
		
		return "detail";
	}
	
//	@GetMapping("/detail") //방법2
//	public String detail(@RequestParam("username") String username, Model model){
//		log.info("detail");
	
//		MemberEntity result = memberRepository.findByUsername(username);
//		model.addAttribute("member", result);
//		
//		return "detail";
//	}

	@GetMapping("/update")
	public String updateForm() {
		log.info("update Form...");
		return "update";
	}
	
	@PostMapping("/update")
	public String update(MemberEntity memberEntity, RedirectAttributes rttr) {
		log.info("update...");
		
		memberRepository.save(memberEntity);
		rttr.addFlashAttribute("username", memberEntity.getUsername());
		
		return "redirect:/detail?username=" + memberEntity.getUsername();
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("username") String username) {
		log.info("delete...");
		
		memberRepository.deleteById(username);
		
		return "redirect:/list";
	}
	
	@GetMapping("/login")
	public String loginGet() {
		log.info("login...");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
	                    @RequestParam("password") String password,
	                    Model model) {

	    int result = memberRepository.countByUsernameAndPassword(username, password);

	    if (result != 1) {
	        return "login";
	    } else {
	        return "index";
	    }
	}

}
