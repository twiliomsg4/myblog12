package com.myblog.myblog12.service;

import com.myblog.myblog12.payload.CommentDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentService {

   CommentDto createComment(CommentDto commentDto, @RequestParam long postId);

   void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);
}
