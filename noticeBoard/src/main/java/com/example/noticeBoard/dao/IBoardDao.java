package com.example.noticeBoard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.noticeBoard.dto.BoardDTO;

@Mapper
public interface IBoardDao {
	
	@Insert("INSERT INTO tbl_board VALUES (seq_board2.nextval, #{board.title}, #{board.content}, #{board.writer}, #{board.regdate})")
	int insert(@Param("board")BoardDTO board);
	List<BoardDTO> selectAll(@Param("start") int start, @Param("end") int end);
}
