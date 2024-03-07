package com.myblog.service.impl;

import com.myblog.entity.Post;
import com.myblog.payload.PostDto;
import com.myblog.repositroy.PostRepository;
import com.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setContent(savedPost.getContent());
        dto.setDescription(savedPost.getDescription());
        return dto;
    }
}
