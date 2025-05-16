package com.example.cbtSite.dto;

import lombok.Data;

@Data
public class CorrectAnswerDTO {
	private String subject_number;
	private int q_number;
	private int correct_answer;
}
