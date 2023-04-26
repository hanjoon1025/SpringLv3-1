package com.sparta.springlv3.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String username;
    private String password;
    private String title;
    private String contents;

}