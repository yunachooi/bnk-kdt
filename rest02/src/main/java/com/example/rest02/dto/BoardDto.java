package com.example.rest02.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
}
