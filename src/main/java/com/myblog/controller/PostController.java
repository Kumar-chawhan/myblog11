package com.myblog.controller;

import com.myblog.payload.PostDto;
import com.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
     //localhost:8080/api/posts
     @PreAuthorize("hasRole('ADMIN')")
     @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);


    }
    // http://localhost:8080/api/posts?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }
    //http://localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=title&sortDir=desc
    @GetMapping
    public List<PostDto> getAllPosts(
            @RequestParam(name = "pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name = "pageSize",required = false,defaultValue = "5")int pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "id")String sortBy,
            @RequestParam(name = "sortDir",required = false,defaultValue = "id")String sortDir
    ){
        List<PostDto> postDtos = postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return postDtos;
    }

}
