package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jt;
	
	/*회원등록*/
	public int writerMember(MemberDTO member) {
		String query = "INSERT INTO tbl_member VALUES(?, ?, ?, ?, ?)";
		
		int result = jt.update(query,
				member.getId(),
				member.getPw(),
				member.getName(),
				member.getPhone(),
				member.getGrade());
		
		return result;
	}
	
	/*특정 회원 자료 조회*/
	public MemberDTO viewMember(String id) {
		String query = "SELECT * FROM tbl_member WHERE id = ?";
		
		MemberDTO member = jt.queryForObject(query,
					new BeanPropertyRowMapper<>(MemberDTO.class),
					id);
		// 하나의 데이터만 추출
		
		return member;
	}
	
	/*전체 자료 조회*/
	public List<MemberDTO> list(){
		String query = "SELECT * FROM tbl_member";
		
		List<MemberDTO> list = jt.query(query, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		/* while문으로 나오는 memberDTO 타입의 자료형을 리스트에 넣는다.(1개 이상의 데이터)*/
		
		return list;
	}	

	/*id 정보로 자료 조회*/
	public MemberDTO detail(String id) {
		String query = "SELECT * FROM tbl_member WHERE id = ?";
		
		MemberDTO member = jt.queryForObject(query,
				new BeanPropertyRowMapper<>(MemberDTO.class),
				id);
		
		return member;
	}
	
	/*회원탈퇴*/
	public int remove(String id) {	
		String query = "DELETE FROM tbl_member WHERE id = ?";
		
		int result = jt.update(query, id);
		
		return result;
	}
}