package com.bloggenerate.demo.Service;

import com.bloggenerate.demo.Entity.Blog;
import com.bloggenerate.demo.Entity.Comment;
import com.bloggenerate.demo.Entity.DTO.BlogDTO;
import com.bloggenerate.demo.Entity.DTO.CommentDTO;
import com.bloggenerate.demo.Entity.User;

import java.util.List;

public interface BlogService {

    Blog saveBlog(Blog blog, Long userId);

    BlogDTO convertEntityToDto(Blog blog);

    List<BlogDTO> getAllBlog();

    BlogDTO updateBlog(Blog blog, int blogId);

    Blog deleteBlog(int blogId);

    BlogDTO getBlogByBlogId(int blogId);

    Blog getSingleBlog(int blogID);
}
