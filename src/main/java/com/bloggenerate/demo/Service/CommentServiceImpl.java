package com.bloggenerate.demo.Service;


import com.bloggenerate.demo.Entity.Blog;
import com.bloggenerate.demo.Entity.Comment;
import com.bloggenerate.demo.Entity.DTO.CommentDTO;
import com.bloggenerate.demo.Entity.User;
import com.bloggenerate.demo.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    UserServiceImpl userService;
    @Autowired
    BlogServiceImpl blogService;

    public List<CommentDTO> getAllComment() {

//        List<Comment> comments = commentRepo.findAll();
        List<Comment> comments = commentRepo.getAllComments();
        List<CommentDTO> cmtDTO = new ArrayList<>();
        for (Comment cmt : comments) {
            CommentDTO commentDTO = convertEntityToDto(cmt);
            cmtDTO.add(commentDTO);
        }
        return cmtDTO;
    }

    @Override
    public CommentDTO convertEntityToDto(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(comment.getCommentId());
        commentDTO.setComments(comment.getComments());
        System.out.println("comment id of " + comment.getCommentId() + " checking child");
        if (comment.getCommentReply() != null && !comment.getCommentReply().isEmpty()) {
            Set<CommentDTO> commentReplyDTOS = new HashSet<>();
            for (Comment comment1 : comment.getCommentReply()) {

                commentReplyDTOS.add(convertEntityToDto(comment1));
            }
            commentDTO.setReplys(commentReplyDTOS);

        }
        return commentDTO;
    }


    @Override
    public CommentDTO saveComment(Comment comment, long userId, int blogId, Integer parentId) {
        User user = userService.findUserByID(userId);

        comment.setUser(user);
        Comment cmt = commentRepo.save(comment);


        if (parentId != null) {
            Comment parent = commentRepo.findById(parentId).get();//parent object get gareko through id.
//            parent.getCommentReply().add(comment);
//            commentRepo.save(parent);

            Set<Comment> cmtrep = parent.getCommentReply();// cmtRep name ko set ma id through get gareko id ko replyObj storre.
            cmtrep.add(comment);
            commentRepo.save(parent);

        } else {
            Blog blog = blogService.getSingleBlog(blogId);
            List<Comment> commentList = blog.getComment();
            commentList.add(comment);
            blogService.saveBlog(blog);
        }

        return convertEntityToDto(cmt);
    }

    @Override
    public Comment saveCmt(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<CommentDTO> getAllComments() {
        return getAllComment();
    }


    @Override
    public CommentDTO updateComment(int updateId, Comment updateComment) {

        Optional<Comment> optionalCmt = commentRepo.findById(updateId);
        Comment comment = optionalCmt.orElse(null);
        if (comment != null) {
            comment.setComments(updateComment.getComments());
            commentRepo.save(comment);
        }
        return convertEntityToDto(comment);
    }


    @Override
    public Comment deleteComment(int commentId) {
        Optional<Comment> optionalComment = commentRepo.findById(commentId);
        Comment commentDelete = optionalComment.orElse(null);
        if (commentDelete != null) {
            commentRepo.delete(commentDelete);
        }
        return commentDelete;
    }


    @Override
    public CommentDTO getCommentById(int commentId) {
        Optional<Comment> optionalComment = commentRepo.findById(commentId);
        Comment comment = optionalComment.orElse(null);
        return convertEntityToDto(comment);
    }


    @Override
    public Comment getSingleComment(int commentId) {

        Optional<Comment> optionalComment = commentRepo.findById(commentId);
        Comment cmtById = optionalComment.orElse(null);
        return cmtById;
    }


}

