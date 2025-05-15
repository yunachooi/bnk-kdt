package com.example.PerformanceSite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.PerformanceSite.dto.QnaDTO;

@Mapper
public interface IQnaDAO {
	List<QnaDTO> listAll();
	void insert(QnaDTO qna);
	QnaDTO detail(@Param("q_no") String q_no);
	void remove(@Param("q_no") String q_no);
}
