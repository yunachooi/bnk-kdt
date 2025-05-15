package com.example.PerformanceSite.dto;

import lombok.Data;

@Data
public class QnaDTO {
	private int q_no;
	private String q_title;
	private String q_content;
	private String q_status;
	private String q_writer;
	private String q_regdate;
}
