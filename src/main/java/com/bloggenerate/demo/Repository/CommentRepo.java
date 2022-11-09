package com.bloggenerate.demo.Repository;

import com.bloggenerate.demo.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
