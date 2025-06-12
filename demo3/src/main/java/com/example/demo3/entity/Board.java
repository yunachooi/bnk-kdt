package com.example.demo3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_board2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)  //다대일, 보통의 경우 LAZY로 설정: 후속코드에서 작성자 정보 요구(board.getMember())시 사용자 정보를 가짐, 부하가 적게 걸림
    @JoinColumn(name = "member_id")
    private Member writer;
}
