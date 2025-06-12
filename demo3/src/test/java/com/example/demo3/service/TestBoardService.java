package com.example.demo3.service;

import com.example.demo3.entity.Board;
import com.example.demo3.entity.Member;
import com.example.demo3.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class TestBoardService {
    @Autowired
    BoardRepository boardRepository;

    //@Test
    //@Transactional //LAZY의 경우 필요, EAGER의 경우 불필요
    public void testGetBoardList(){
        List<Board> list = boardRepository.findAll();

        for(Board board : list){
            System.out.println(board.getTitle() + " | " + board.getWriter().getUsername());
        }
    }

    //@Test //LAZY의 경우 사용
    void testGetBoardListFetch(){
        List<Board> list = boardRepository.getBoardListWithMember();
        for(Board board : list){
            System.out.println(board.getTitle() + " | " + board.getWriter().getUsername());
        }
    }

    @Test
    public void insertBoardDummies(){
        Member member = new Member();
        member.setMember_id(1);

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Board board = Board.builder()
                    .title("test title" + i)
                    .content("test content.." + i)
                    .writer(member)
                    .build();
            boardRepository.save(board);
        });
    }
}
