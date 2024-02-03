package com.myblog.myblog12.service.impl;

import com.myblog.myblog12.entity.Post;
import com.myblog.myblog12.payload.PostDto;
import com.myblog.myblog12.repository.PostRepository;
import com.myblog.myblog12.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // Create a Post entity and set its properties
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        // Save the Post entity to the database
        Post savedPost = postRepository.save(post);

        // Create a PostDto and copy properties from the saved Post entity
        PostDto dto = new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());

        // Return the PostDto

        return dto;



    }

}
