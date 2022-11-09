package com.bloggenerate.demo.Service;

import com.bloggenerate.demo.Entity.Comment;
import com.bloggenerate.demo.Entity.DTO.CommentDTO;
import com.bloggenerate.demo.Entity.User;

import java.util.List;

public interface CommentService {

    CommentDTO saveComment(Comment comments, long userId, int blogId);
    CommentDTO convertEntityToDto(Comment comment);
    CommentDTO updateComment(int commentId, Comment comment);
    Comment deleteComment(int commentId);
    CommentDTO getCommentById(int commentId);
    List<CommentDTO> getAllComments();


}
