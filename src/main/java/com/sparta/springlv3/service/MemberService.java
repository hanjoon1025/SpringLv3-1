package com.sparta.springlv3.service;


import com.sparta.springlv3.dto.MemberRequestDto;
import com.sparta.springlv3.dto.SignupRequestDto;
import com.sparta.springlv3.entity.Member;
import com.sparta.springlv3.jwt.JwtUtil;
import com.sparta.springlv3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;


    @Transactional(readOnly = true)
    public void login(MemberRequestDto memberRequestDto, HttpServletResponse response){
        String userName = memberRequestDto.getUsername();
        String password = memberRequestDto.getPassword();

        Member member = memberRepository.findByUsername(userName).orElseThrow(
                () -> new IllegalArgumentException("등록된 아이디가 없습니다.")
        );

        if(!member.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(member.getUsername()));
    }
    @Transactional
    public void signup(SignupRequestDto signupRequestDto)  {
        //회원가입 유저 아이디 중복확인
        Optional<Member> overlapUser = memberRepository.findByUsername(signupRequestDto.getUsername());
        if(overlapUser.isPresent()) throw new IllegalArgumentException("중복된 아이디가 있습니다.");
        memberRepository.save(new Member(signupRequestDto));

    }



}