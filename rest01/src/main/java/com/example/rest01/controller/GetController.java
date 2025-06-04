package com.example.rest01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest01.dto.MemberDto;
import com.example.rest01.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	List<MemberDto> list = new ArrayList<>();
	@Autowired
	MemberRepository memberRepository;

	// http://localhost:8090/api/v1/get-api/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	// http://localhost:8090/api/v1/get-api/variable1/{variable}
	@GetMapping("/variable1/{variable}")
	public String variable1(@PathVariable("variable") String variable) {
		return variable;
	}

	// http://localhost:8090/api/v1/get-api/request1?name=value&email=value&organazation=value
	@GetMapping("/request1")
	public String request1(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("organazation") String organazation) {
		return name + ", " + email + ", " + organazation;
	}

	// http://localhost:8090/api/v1/get-api/request2?key1=value&key2=value2 map이용
	@GetMapping("/request2")
	public String request2(@RequestParam Map<String, String> mapParam) {
		return mapParam.get("key1") + ", " + mapParam.get("key2");
	}

	// http://localhost:8090/api/v1/get-api/request3?name=value&email=value&organazation=value
	@GetMapping("/request3")
	public String request3(MemberDto memberDto) {
		return memberDto.getName() + ", " + memberDto.getEmail() + ", " + memberDto.getOrganazation();
	}

	// http://localhost:8090/api/v1/get-api/request4/{name}
	@GetMapping("/request4/{name}")
	public String request4(@PathVariable("name") String name) {
		MemberDto member1 = new MemberDto();
		member1.setName("Ann");
		member1.setEmail("Ann@green.com");
		member1.setOrganazation("GREEN");

		MemberDto member2 = new MemberDto();
		member2.setName("Ben");
		member2.setEmail("Ben@green.com");
		member2.setOrganazation("GREEN");

		MemberDto member3 = new MemberDto();
		member3.setName("Choi");
		member3.setEmail("Choi@green.com");
		member3.setOrganazation("GREEN");

		list.add(member1);
		list.add(member2);
		list.add(member3);

		for (MemberDto member : list) {
			if (member.getName().equals(name)) {
				// return member.getName() + ", " + member.getEmail() + ", " +
				// member.getOrganazation();
				return "200" + "..." + member.toString();
			}
		}
		return "404 Error...NULL";

	}

	// http://localhost:8090/api/v1/get-api/request5/{name}
	@GetMapping("/request5/{name}")
	public ResponseEntity<MemberDto> request5(@PathVariable("name") String name) {
		MemberDto member1 = new MemberDto();
		member1.setName("Ann");
		member1.setEmail("Ann@green.com");
		member1.setOrganazation("GREEN");

		MemberDto member2 = new MemberDto();
		member2.setName("Ben");
		member2.setEmail("Ben@green.com");
		member2.setOrganazation("GREEN");

		MemberDto member3 = new MemberDto();
		member3.setName("Choi");
		member3.setEmail("Choi@green.com");
		member3.setOrganazation("GREEN");

		list.add(member1);
		list.add(member2);
		list.add(member3);

		for (MemberDto member : list) {
			if (member.getName().equals(name)) {
				return ResponseEntity.status(HttpStatus.OK).body(member); // 200
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
	}
}
