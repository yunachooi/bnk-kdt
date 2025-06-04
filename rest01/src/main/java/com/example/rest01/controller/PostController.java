package com.example.rest01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest01.dto.MemberDto;
import com.example.rest01.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	/*
	 * post : 등록
	 * put : 수정
	 * delete : 삭제
	 * */
	
	List<MemberDto> list = new ArrayList<>();
	@Autowired
	MemberRepository memberRepository;
	
	//http://localhost:8090/api/v1/post-api/domain
	@PostMapping("/domain")
	public String postEx() {
		return "Hello Post API";
	}
	
	//http://localhost:8090/api/v1/post-api/member
	@PostMapping("/member")
	public MemberDto PostMember(@RequestBody MemberDto memberDto) {		
		return memberDto;
	}
	
	//http://localhost:8090/api/v1/post-api/member2
	@PostMapping("/member2")
	public String PostMember2(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + ":" + map.getValue() + "\n");
		});
		return sb.toString();
	}
	
	//http://localhost:8090/api/v1/post-api/member3
	@PostMapping("/member3")
	public ResponseEntity<MemberDto> PostMember3(@RequestBody MemberDto memberDto) {
		MemberDto member1 = new MemberDto();
		member1.setEmail("kim@green.com");
		
		list.add(member1);
		
		boolean flag = false;
		for(MemberDto member : list) {
			if(member.getEmail().equals(memberDto.getEmail())) {
				flag = true;
			}
		}
		
		if (memberDto.getEmail() == null) {
			//이메일이 null인 경우
			return ResponseEntity.badRequest().build();
		} else if(flag) {
			//이메일이 중복인 경우
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); //409
		} else {
			//등록이 잘 된 경우
			return ResponseEntity.status(HttpStatus.CREATED).body(memberDto); //201
		}
	}
	
	//http://localhost:8090/api/v1/post-api/member4
	@PostMapping("/member4")
	public ResponseEntity<MemberDto> PostMember4(@RequestBody MemberDto memberDto) {
		List<MemberDto> list = memberRepository.getList();
		boolean flag = false;
		
		for (MemberDto member : list) {
			if (member.getEmail().equals(memberDto.getEmail())) {
				flag = true;
				break;
			}
		}
		
		if (memberDto.getEmail() == null) {
	        return ResponseEntity.badRequest().build();
	    } else if (flag) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).build();
	    } else if(memberRepository.addList(memberDto)){
	    	return ResponseEntity.status(HttpStatus.CREATED).body(memberDto);
	    } else {
	    	return ResponseEntity.unprocessableEntity().build();
	    }
		
	}
}
