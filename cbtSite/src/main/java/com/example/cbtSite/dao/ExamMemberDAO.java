package com.example.cbtSite.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.cbtSite.dto.ExamMemberDTO;

@Mapper
public interface ExamMemberDAO {
	ExamMemberDTO selectMember(@Param("e_number") String e_number);

	String getId(@Param("e_number")String e_number);
}
