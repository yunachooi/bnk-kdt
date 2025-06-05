package com.example.rest02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest02.entity.BoardEntity;
import com.example.rest02.service.BoardService;

@RestController
@RequestMapping("/api/board-get")
public class GetBoardController {
	@Autowired
	private BoardService boardService;
	
	//http://localhost:8090/api/board-get/board
	@GetMapping("/board/{bno}")
	public ResponseEntity<BoardEntity> getBoardByBno(@PathVariable("bno") Integer bno) {
		BoardEntity entity = boardService.getBoardByBno(bno);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
}
