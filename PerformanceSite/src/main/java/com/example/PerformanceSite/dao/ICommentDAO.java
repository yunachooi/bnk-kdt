package com.example.PerformanceSite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.PerformanceSite.dto.CommentDTO;

@Mapper
public interface ICommentDAO {
	void insert(@Param("c_writer")String c_writer, @Param("c_comment")String c_comment, @Param("p_code")String p_code);
	List<CommentDTO> pCodeList (@Param("p_code") String p_code);
	void remove(@Param("c_no") String c_no);
}
