package com.example.rest02.util;

import com.example.rest02.dto.BoardDto;
import com.example.rest02.entity.BoardEntity;

public class Convert {
	public BoardEntity dtoToEntityWithBno(BoardDto boardDto) {
		BoardEntity boardEntity = new BoardEntity();
		
		boardEntity.setBno(boardDto.getBno());
		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setContent(boardDto.getContent());
		boardEntity.setWriter(boardDto.getWriter());
		
		return boardEntity;
	}
	
	public BoardEntity dtoToEntity(BoardDto boardDto) {
		BoardEntity boardEntity = new BoardEntity();
		
		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setContent(boardDto.getContent());
		boardEntity.setWriter(boardDto.getWriter());
		
		return boardEntity;
	}
	
	public BoardDto entityToDto(BoardEntity boardEntity) {
		BoardDto boardDto = new BoardDto();
		
		boardDto.setBno(boardEntity.getBno());
		boardDto.setTitle(boardEntity.getTitle());
		boardDto.setContent(boardEntity.getContent());
		boardDto.setWriter(boardEntity.getWriter());
		
		return boardDto;
	}
}
