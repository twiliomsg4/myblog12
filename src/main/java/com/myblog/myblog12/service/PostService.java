package com.myblog.myblog12.service;

import com.myblog.myblog12.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);


    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
