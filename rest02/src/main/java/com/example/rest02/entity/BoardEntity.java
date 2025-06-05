package com.example.rest02.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_board3")
@Data
public class BoardEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bno;
	private String title;
	private String content;
	private String writer;
//	private LocalDateTime regDate;
//	private LocalDateTime modDate;
} 