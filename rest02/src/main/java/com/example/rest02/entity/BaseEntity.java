package com.example.rest02.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public abstract class BaseEntity {
	@Column(name = "regdate", updatable = false)
	@CreatedDate
	private LocalDateTime regDate; //등록 시간
	@Column(name = "moddate")
	@LastModifiedDate
	private LocalDateTime modDate; //수정 시간
}
