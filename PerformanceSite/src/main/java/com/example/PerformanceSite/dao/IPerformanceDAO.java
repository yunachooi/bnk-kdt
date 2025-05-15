package com.example.PerformanceSite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.PerformanceSite.dto.PerformanceDTO;

@Mapper
public interface IPerformanceDAO {
	void insertInfo(@Param("p") PerformanceDTO perform);
	List<PerformanceDTO> listAll();
	PerformanceDTO detail(@Param("p_code") String p_code);
	List<PerformanceDTO> listState(@Param("p_state") String p_state);
	void remove(@Param("p_code") String p_code);
}
