package com.example.jpaEx01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity //선언
@Table(name = "tbl_member2")
@Getter
@Setter
public class MemberEntity {
	@Id //primary Key 지정
	private String username;
	
	private String password;
	private String name;
	private String role;
}
