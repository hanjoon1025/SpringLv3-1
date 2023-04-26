package com.sparta.springlv3.controller;

import com.sparta.springlv3.dto.BoardRequestDto;
import com.sparta.springlv3.dto.BoardResponseDto;
import com.sparta.springlv3.dto.CommentRequestDto;
import com.sparta.springlv3.dto.CommentResponseDto;
import com.sparta.springlv3.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/comment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto, HttpServletRequest request) {
        return commentService.createComment(requestDto, request);
    }
    //댓글 수정
    @PutMapping("/comment/{id}")
    public CommentResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request){
        return commentService.updateComment(id, commentRequestDto, request);
    }



}
