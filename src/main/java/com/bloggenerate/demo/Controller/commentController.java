package com.bloggenerate.demo.Controller;


import com.bloggenerate.demo.Entity.Comment;
import com.bloggenerate.demo.Entity.DTO.CommentDTO;
import com.bloggenerate.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class commentController {

    @Autowired
    CommentService commentService;


    @PostMapping("/saveComment")
//    public Comment saveComment(@RequestBody(required = false) Comment comment, @RequestParam("userId") Long userId, @RequestParam("blogId") int blogId){
    public CommentDTO saveComment(@RequestBody Comment comment, @RequestParam("userId") Long userId, @RequestParam("blogId") int blogId,@RequestParam(required = false) Integer parentId){
          return commentService.saveComment(comment, userId, blogId,parentId);
    }


    @GetMapping("/comments")
    public List<CommentDTO> getAllComments(){
        return commentService.getAllComments();
    }


    @PutMapping("/comment/{commentId}")
    public CommentDTO updateComment(@RequestBody Comment comment, @PathVariable("commentId") int commentId){
        return commentService.updateComment(commentId, comment);
    }

    @DeleteMapping("/comment/{commentId}")
    public Comment deleteComment(@PathVariable("commentId") int commentId){
        return  commentService.deleteComment(commentId);
    }

    @GetMapping("/comment/{commentId}")
    public CommentDTO getCommentById(@PathVariable("commentId") int commentId){
        return commentService.getCommentById(commentId);
    }


}
