package com.bloggenerate.demo.Entity.DTO;

import com.bloggenerate.demo.Entity.Comment;

import java.util.List;
import java.util.Set;

public class CommentDTO {

    private int commentId;
    private String comments;
    private Set<CommentDTO> replys;

    public Set<CommentDTO> getReplys() {
        return replys;
    }

    public void setReplys(Set<CommentDTO> replys) {
        this.replys = replys;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
