package com.myblog.myblog12.controller;

import com.myblog.myblog12.payload.CommentDto;
import com.myblog.myblog12.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // POST request to http://localhost:8080/api/comment?postId=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId) {

        CommentDto dto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/comments/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted!!",HttpStatus.OK);

    }
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable long id,@RequestBody CommentDto commentDto,@PathVariable long postId){
        CommentDto Dto = commentService.updateComment(id, commentDto,postId);
        return new ResponseEntity<>(Dto,HttpStatus.OK);

    }
}

