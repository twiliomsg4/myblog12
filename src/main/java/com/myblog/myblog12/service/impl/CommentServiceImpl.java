package com.myblog.myblog12.service.impl;

import com.myblog.myblog12.entity.Comment;
import com.myblog.myblog12.entity.Post;
import com.myblog.myblog12.exception.ResourceNotFoundException;
import com.myblog.myblog12.payload.CommentDto;
import com.myblog.myblog12.repository.CommentRepository;
import com.myblog.myblog12.repository.PostRepository;
import com.myblog.myblog12.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private  PostRepository postRepository;
    private  CommentRepository commentRepository;

    private ModelMapper modelMapper;



    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found with id:" + postId)
        );

        Comment comment = new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());

        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found for id: " + postId)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment Not Found for id: " + id)
        );

        Comment updatedComment = mapToEntity(commentDto);
        updatedComment.setId(comment.getId());
        updatedComment.setPost(post);

        Comment savedComment = commentRepository.save(updatedComment);

        return mapToDto(savedComment);
    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

    Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }
}

