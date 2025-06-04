package com.example.rest01.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rest01.dto.MemberDto;

@Repository
public class MemberRepository {
	List<MemberDto> list = new ArrayList<>();
	
	public MemberRepository() {
		addDefault();
	}
	
	void addDefault() {
		MemberDto member1 = new MemberDto();
		member1.setName("kim");
		member1.setEmail("kim@green.com");
		member1.setOrganazation("GREEN");
		
		MemberDto member2 = new MemberDto();
		member2.setName("lee");
		member2.setEmail("lee@green.com");
		member2.setOrganazation("GREEN");
		
		MemberDto member3 = new MemberDto();
		member3.setName("park");
		member3.setEmail("park@green.com");
		member3.setOrganazation("GREEN");
		
		list.add(member1);
		list.add(member2);
		list.add(member3);
	}
	
	void add(MemberDto member) {
		MemberDto members = new MemberDto();
		
		members.setName(member.getName());
		members.setEmail(member.getEmail());
		members.setOrganazation(member.getOrganazation());
		
		list.add(members);
	}
	
	public boolean addList(MemberDto member) {
		return list.add(member);
	}
	
	public List<MemberDto> getList(){
		return list;
	}
}
