package com.example.sessionEx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sessionEx.dto.UserDTO;

@Mapper
public interface IUserDao {
	UserDTO login(@Param("id") String id, @Param("pw") String pw);
}