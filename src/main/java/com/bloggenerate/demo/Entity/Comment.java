package com.bloggenerate.demo.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Comment> commentReply;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getCommentReply() {
        return commentReply;
    }

    public void setCommentReply(Set<Comment> commentReply) {
        this.commentReply = commentReply;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comments='" + comments + '\'' +
                ", user=" + user +
                ", commentReply=" + commentReply +
                '}';
    }
}
