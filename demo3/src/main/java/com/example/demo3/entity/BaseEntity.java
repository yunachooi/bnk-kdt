package com.example.demo3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@EntityListeners(value = {AutoCloseable.class})
@MappedSuperclass
@Getter
public class BaseEntity {
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "moddate")
    private LocalDateTime modifiedAt;
}
