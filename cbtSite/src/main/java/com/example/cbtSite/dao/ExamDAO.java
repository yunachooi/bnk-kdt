package com.example.cbtSite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.cbtSite.dto.CorrectAnswerDTO;
import com.example.cbtSite.dto.ExamResponseDTO;

@Mapper
public interface ExamDAO {
	void insertResponse(@Param("response") ExamResponseDTO response);
	CorrectAnswerDTO getCorrectAnswer(@Param("subject_number")String subject_number, @Param("q_number") int q_number);
	List<CorrectAnswerDTO> getAllCorrectAnswers(@Param("subject_number") String subjectNumber);
}
