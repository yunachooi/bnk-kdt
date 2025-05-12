package com.example.noticeBoard.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.noticeBoard.dto.BoardDTO;

@SpringBootTest
class BoardDaoTest {
	
	@Autowired
	IBoardDao boardDao;

	@Test
	void testInsert() {
		for(int i = 0; i < 100; i++) {
			BoardDTO board = new BoardDTO();
			
			board.setTitle("title" + i);
			board.setContent("content" + i);
			board.setWriter("id01");
			board.setRegdate("2025/05/12");
			
			boardDao.insert(board);
		}
	}

}