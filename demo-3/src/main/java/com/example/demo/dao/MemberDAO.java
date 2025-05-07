package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MemberDTO;

@Repository // 인스턴스 자동 연결, Spring 프레임워크에서 관리
public class MemberDAO {
	
	@Autowired // JDBC API 쿼리 실행 시 자동으로 리스트에 생성(Controller가 DAO를 참조)
	private JdbcTemplate jt;
	
	/*INSERT*/
	public int writeMember(MemberDTO member) {
		String query = "INSERT INTO tbl_member VALUES(?, ?, ?, ?, ?)";
		int result = jt.update(query,
				member.getId(),
				member.getPw(),
				member.getName(),
				member.getPhone(),
				member.getGrade());
		
		return result;		
	}
	
	/*SELECT-하나의 데이터 조회*/
	public MemberDTO viewMember(String id) {
		String query = "SELECT * FROM tbl_member WHERE id = ?";
		MemberDTO member =jt.queryForObject(query, //queryForObject: 단 하나의 행 데이터 추출, 타입을 지정해주기 위함
				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class), id);
		
		return member ;
	}
	
	/*SELECT-전체 데이터 조회*/
	public List<MemberDTO> list() {
		String query = "SELECT * FROM tbl_member";
		List<MemberDTO> list = jt.query(query, //목록 데이터 얻을 때
				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		
		return list;
	}
	
	/*UPDATE*/
	public int updateMember(MemberDTO member) {
		String query = "UPDATE tbl_member SET pw = ?, name = ?, phone =?, grade = ? WHERE id =?";
		int result = jt.update(query,
				member.getPw(),
				member.getName(),
				member.getPhone(),
				member.getGrade(),
				member.getId());
		
		return result ; 
	}
	
	/*DElETE*/
	public int deleteMember(String id) {
		String query = "DELETE FROM tbl_member WHERE id = ?";
		int result = jt.update(query, id);
		
		return result;
	}
}
