package com.bloggenerate.demo.Service;

import com.bloggenerate.demo.Entity.Comment;
import com.bloggenerate.demo.Entity.DTO.CommentDTO;
import com.bloggenerate.demo.Entity.User;

import java.util.List;
import java.util.Set;

public interface CommentService {

    Comment saveCmt(Comment comment);
    CommentDTO saveComment(Comment comments, long userId, int blogId, Integer parentId);
    CommentDTO convertEntityToDto(Comment comment);
    CommentDTO updateComment(int commentId, Comment comment);
    Comment deleteComment(int commentId);
    CommentDTO getCommentById(int commentId);
    List<CommentDTO> getAllComments();
    Comment getSingleComment (int commentId);

}
