package com.example.demo3;

import com.example.demo3.service.UserService;

public class JpaExMain {
    public static void main(String[] args){
        UserService userService = new UserService();

        //CREATE - 새로운 자료 저장
        //userService.createUser("Alice", "alice@green.com", 30);
        //userService.createUser("Bob", "bob@green.com", 25);
        //userService.createUser("Charlie", "charlie@green.com", 28);

        //READ - 사용자 조회(PK 사용)
        userService.findUserById(1l);

        //READ - 모든 사용자 조회
        userService.findAllUsers();

        //UPDATE - 사용자 정보 수정
        userService.updateUser(1l, "alice-update@green.com");
    }
}
