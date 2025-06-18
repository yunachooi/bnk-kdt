package com.example.demo3.repository;

import com.example.demo3.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    //기본 CRUD
    //INSERT/UPDATE : save(), SELECT: find-(), DELETE: delete-()

    //1.
    //long count = memberRepository.count();

    //2.
    //no usage
    long countBy();

    //3.
    //Query 어노테이션 사용
    @Query("SELECT COUNT(m) FROM Member m")
    long countAllMembers();

    //4.
    //native Query 사용
    @Query(value = "SELECT COUNT(*) FROM tbl_member2", nativeQuery = true)
    long countAllMembersNative();

}
