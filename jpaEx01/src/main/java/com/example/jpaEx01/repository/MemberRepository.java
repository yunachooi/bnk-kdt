package com.example.jpaEx01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx01.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String>{

	MemberEntity findByUsername(String username); //쿼리 메서드
	
}