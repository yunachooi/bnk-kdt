package com.example.cbtSite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamResponseDTO {
	private String e_number;
	private int q_number;
	private int answer;
}
