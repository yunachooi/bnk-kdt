package com.example.rest02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest02.dto.BoardDto;
import com.example.rest02.entity.BoardEntity;
import com.example.rest02.service.BoardService;

@RestController
@RequestMapping("/api/board-put")
public class PutBoardController {
	@Autowired
	private BoardService boardService;
	
	//http://localhost:8090/api/board-put/board
	@PutMapping("/board")
	public ResponseEntity<BoardEntity> putBoard(@RequestBody BoardDto boardDto) {
		BoardEntity result = boardService.updateBoard(boardDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
}
