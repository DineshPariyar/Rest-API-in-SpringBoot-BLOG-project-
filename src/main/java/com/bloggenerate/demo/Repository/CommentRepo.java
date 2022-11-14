package com.bloggenerate.demo.Repository;

import com.bloggenerate.demo.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {


//    @Query(name = select * from comment where comment_cid not in(select comment_reply_comment_id from comment_comment_reply), nativeQuery = true)
//    List<Comment> getAllComment();

    @Query(value = "select * from comment where comment_id not in (select comment_comment_reply.comment_reply_comment_id from comment_comment_reply)", nativeQuery = true)
    List<Comment> getAllComments();

}
