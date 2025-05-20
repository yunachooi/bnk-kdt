package com.example.sessionEx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sessionEx.dto.UserDTO;

@Mapper
public interface IUserDao {
	UserDTO login(@Param("id") String id, @Param("pw") String pw);
	List<UserDTO> getUserList();
	List<UserDTO> getUserListWithParam(@Param("user")UserDTO user);
	List<UserDTO> getUserListWithParam2(@Param("user")UserDTO user);
}