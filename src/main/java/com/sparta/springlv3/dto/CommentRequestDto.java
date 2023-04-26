package com.sparta.springlv3.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {
    private Long id; // 게시글 ID
    private String content; //작성할 댓글

}
