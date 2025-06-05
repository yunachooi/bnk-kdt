package com.example.rest02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest02.dto.BoardDto;
import com.example.rest02.entity.BoardEntity;
import com.example.rest02.repository.BoardRepository;
import com.example.rest02.util.Convert;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	//게시글 등록 업무(기능: registBoard, 준비: 게시글, 결과: BoardEntity)
	public BoardEntity registBoard(BoardDto boardDto){
		Convert convert = new Convert();
		BoardEntity boardEntity = convert.dtoToEntity(boardDto);
		
		BoardEntity result = boardRepository.save(boardEntity);
		
		return result;
	}
	
	//게시글 조회 업무(기능: getBoardByBno, 준비: bno, 결과: List<BoardEntity>)
	public BoardEntity getBoardByBno(Integer bno){
		BoardEntity boardEntity = boardRepository.findByBno(bno);
		return boardEntity;
	}
	
	//게시글 수정 업무(기능: updateBoard, 준비: 수정된 게시글, 결과: BoardEntity)
	public BoardEntity updateBoard(BoardDto boardDto) {
		Convert convert = new Convert();
		BoardEntity boardEntity = convert.dtoToEntityWithBno(boardDto);
		
		BoardEntity result = boardRepository.save(boardEntity);
		
		return result;
	}
	
	//게시글 삭제 업무(기능: deleteBoard, 준비: bno)
	public void deleteBoard(Integer bno) {
		boardRepository.deleteById(bno);
	}
}
