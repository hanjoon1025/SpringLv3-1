package com.sparta.springlv3.entity;

import com.sparta.springlv3.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    private UserRoleEnum role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;





    public Member(SignupRequestDto signupRequestDto, UserRoleEnum role) {

        this.username = signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();

    }
}
