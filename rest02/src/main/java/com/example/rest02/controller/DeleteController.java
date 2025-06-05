package com.example.rest02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest02.entity.BoardEntity;
import com.example.rest02.service.BoardService;

@RestController
@RequestMapping("/api/board-delete")
public class DeleteController {
	@Autowired
	BoardService boardService;
	
	//http://localhost:8090/api/board-delete/board/1
	@DeleteMapping("/board/{bno}")
	public ResponseEntity<BoardEntity> delete(@PathVariable("bno") Integer bno) {
		boardService.deleteBoard(bno);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
