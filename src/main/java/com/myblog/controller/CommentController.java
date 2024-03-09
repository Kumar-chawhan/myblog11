package com.myblog.controller;

import com.myblog.payload.CommentDto;
import com.myblog.payload.PostDto;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

   // http://localhost:8080/api/comments
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @RequestParam long postId){
        CommentDto dto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted",HttpStatus.OK);

    }
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable long id,@RequestBody CommentDto commentDto,@PathVariable long postId){
       CommentDto dto =  commentService.updateComment(id,commentDto,postId);
       return new ResponseEntity<>(dto,HttpStatus.OK);


    }
}
