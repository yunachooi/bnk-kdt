package com.example.PerformanceSite.dto;

import lombok.Data;

@Data
public class CommentDTO {
	private int c_no;
	private String c_writer;
	private String c_comment;
	private String c_regdate;
}
