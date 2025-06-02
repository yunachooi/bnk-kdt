package com.example.securityEx01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.securityEx01.dto.UserDto;
import com.example.securityEx01.entity.User;
import com.example.securityEx01.service.JoinService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private JoinService joinService;

    @GetMapping("/")
    public String root() {
        log.info("root...");
        return "index";
    }

    @GetMapping("/regMember")
    public String regMember() {
        log.info("regForm...");
        return "regForm";
    }

    @PostMapping("/regist")
    public @ResponseBody String regMember(UserDto userDto) {
        log.info("userDto..." + userDto);
        User result = joinService.regist(userDto);
        if (result != null){
        	return "회원가입 완료";
        } else {
        	return "회원가입 실패";
        }
    }
    
    @GetMapping("/login")
    public String loginForm() {
    	return "loginForm";
    }
    
    @GetMapping("/fail")
    public String fail() {
    	return "fail";
    }
    
    @GetMapping("/loginProc")
    public String loginProc() {
    	return "loginProc";
    }
}
