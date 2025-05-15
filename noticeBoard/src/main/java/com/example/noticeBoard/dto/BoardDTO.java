package com.example.noticeBoard.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
}
