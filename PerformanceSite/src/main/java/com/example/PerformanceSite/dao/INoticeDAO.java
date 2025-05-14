package com.example.PerformanceSite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.PerformanceSite.dto.NoticeDTO;
import com.example.PerformanceSite.dto.PerformanceDTO;

@Mapper
public interface INoticeDAO {
	List<NoticeDTO> listAll();

	void insert(NoticeDTO notice);

	NoticeDTO detail(@Param("n_no") String n_no);
}
