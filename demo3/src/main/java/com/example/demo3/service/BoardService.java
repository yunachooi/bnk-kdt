package com.example.demo3.service;

import com.example.demo3.entity.Board;
import com.example.demo3.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public List<Board> getBoardList(){
        List<Board> list = boardRepository.findAll();

        return list;
    }
}
