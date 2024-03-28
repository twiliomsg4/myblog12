package com.myblog.myblog12.service.impl;

import com.myblog.myblog12.entity.Post;
import com.myblog.myblog12.exception.ResourceNotFoundException;
import com.myblog.myblog12.payload.PostDto;
import com.myblog.myblog12.repository.PostRepository;
import com.myblog.myblog12.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // Convert PostDto to Post entity
        Post post = mapToEntity(postDto);

        // Save the Post entity to the database
        Post savedPost = postRepository.save(post);

        // Convert saved Post entity back to PostDto and return
        return mapToDto(savedPost);
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id:" + id)
        );

        // Convert Post entity to PostDto and return
        return mapToDto(post);
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
       Sort sort =  (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> posts = pagePost.getContent();
        List<PostDto> dtos = posts.stream().map(post->mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }

        PostDto mapToDto(Post post) {
        PostDto dto = modelMapper.map(post,PostDto.class);
        return dto;
    }

        Post mapToEntity(PostDto postDto) {
            Post post = modelMapper.map(postDto, Post.class);
            return post;
    }
}
