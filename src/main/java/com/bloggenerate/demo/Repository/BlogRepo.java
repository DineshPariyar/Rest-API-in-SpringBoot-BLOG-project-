package com.bloggenerate.demo.Repository;

import com.bloggenerate.demo.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Integer> {

    Blog findByBlogId(int blogId);
}
