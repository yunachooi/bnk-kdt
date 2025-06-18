package com.example.demo3.repository;

import com.example.demo3.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b JOIN FETCH b.writer") //JOIN FETCH: 일시적, 정보를 즉시 불러옴(LAZY)
    public List<Board> getBoardListWithMember(); //조회: find

}
