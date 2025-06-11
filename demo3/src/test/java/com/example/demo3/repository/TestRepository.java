package com.example.demo3.repository;

import com.example.demo3.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestRepository {
    @Autowired
    MemberRepository memberRepository;

    //@Test
    void countMEmberTestNative(){
        long count = memberRepository.countAllMembers();
        assertEquals(4, count, "오류발생");
    }

    //@Test
    void countMemberTest(){
        long count = memberRepository.count();
        assertEquals(5, count, 1);
    }

    //@Test
    void countMemberTest2(){
        long count = memberRepository.countBy();
        assertEquals(4, count);
    }

    //@Test
    void selectTest(){
        List<Member> list = memberRepository.findAll();
        assertNotNull(list, "사용자 없음");
    }

    //@Test
    void deleteTest(){
        memberRepository.deleteById(1);
    }

    @Test
    void updateTest(){
        Member member = Member.builder()
                .member_id(2)
                .username("user1")
                .password("12341")
                .name("user1")
                .phone("010-1234-1231")
                .build();
        memberRepository.save(member);
    }

    //@Test
    void insertDummies(){
        IntStream.rangeClosed(0, 3).forEach(i -> {
            Member member = Member.builder()
                .username("user" + i)
                .password("1234" + i)
                .name("user" + i)
                .phone("010-1234-123" + i)
                .build();
            memberRepository.save(member);
        });
    }
}
