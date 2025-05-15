package com.example.PerformanceSite.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.PerformanceSite.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	String getMemberId(@Param("id") String id);

	void insertMember(@Param("m") MemberDTO member);

	MemberDTO getMember(@Param("id") String id);

}
