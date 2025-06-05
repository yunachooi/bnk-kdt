package com.example.rest02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest02.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

	BoardEntity findByBno(Integer bno);

}
