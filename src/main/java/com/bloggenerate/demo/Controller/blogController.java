package com.bloggenerate.demo.Controller;


import com.bloggenerate.demo.Entity.Blog;
import com.bloggenerate.demo.Entity.DTO.BlogDTO;
import com.bloggenerate.demo.Service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class blogController {

    @Autowired
    BlogServiceImpl blogService;


    @PostMapping("/blog/{userId}")
    public Blog saveBlog(@RequestBody Blog blog, @PathVariable("userId") long userId){
        Blog blog1=blogService.saveBlog(blog, userId);
        return blog1;
    }


    @GetMapping("/blog")
    public List<BlogDTO> getAllBlog(){
        return blogService.getAllBlog();
    }



    @PutMapping("/blog/{blogId}")
    public BlogDTO updateBlog(@RequestBody Blog blog, @PathVariable("blogId") int blogId){
        return  blogService.updateBlog(blog,blogId);
    }

    @DeleteMapping("/blog/{blogId}")
    public Blog deleteBlog(@PathVariable String blogId){
        return blogService.deleteBlog(Integer.parseInt(blogId));
    }

    @GetMapping("/blog/{blogId}")
    public BlogDTO getBlogById(@PathVariable("blogId") int blogId){
        return blogService.getBlogByBlogId(blogId);

    }
}
