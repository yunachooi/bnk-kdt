package com.example.demo3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tbl_member2")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer member_id;
    @Column(length = 50, unique = true)
    @Size(min = 3, max = 50)
    private String username;
    @Column(length = 20)
    @Size(min = 4, max = 20)
    private String password;
    private String name;
    @Column(length = 13)
    @Size(max = 13, message = "전화번호는 최대 13자리까지 입력됩니다.")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.(예: 010-1234-5678)")
    private String phone;
}
