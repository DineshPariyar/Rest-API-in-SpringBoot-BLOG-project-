package com.bloggenerate.demo.Service;

import com.bloggenerate.demo.Entity.Blog;
import com.bloggenerate.demo.Entity.Comment;
import com.bloggenerate.demo.Entity.DTO.BlogDTO;
import com.bloggenerate.demo.Entity.DTO.CommentDTO;
import com.bloggenerate.demo.Entity.User;
import com.bloggenerate.demo.Repository.BlogRepo;
import com.bloggenerate.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepo blogRepo;

    @Autowired
    UserRepo userRepo;

    @Lazy
    @Autowired
    CommentService commentService;

    public List<BlogDTO> getAllBlogs(){
        List<Blog> blogLists= blogRepo.findAll();
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (Blog blog1:blogLists) {
            BlogDTO blogDTO = convertEntityToDto(blog1);
            blogDTOList.add(blogDTO);
        }

        return blogDTOList;
    }


        public BlogDTO convertEntityToDto(Blog blog){
        List<Comment> cmt = blog.getComment();
        List<CommentDTO> cmtDTOs = new ArrayList<>();

        for (Comment com:cmt) {
            CommentDTO cmtDTO =commentService.convertEntityToDto(com);
            cmtDTOs.add(cmtDTO);
        }

        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setBlogId(blog.getBlogId());
        blogDTO.setContent(blog.getContent());
        blogDTO.setCommentDTOS(cmtDTOs);

        return blogDTO;
    }


    @Override
    public List<BlogDTO> getAllBlog(){

//        Blog blog = (Blog) blogRepo.findAll();
//        blogList.add(blog);
//        BlogDTO blogDTO = convertEntityToDto(blog);
//        List<BlogDTO> blogDTOS = new ArrayList<>();
//        blogDTOS.add(blogDTO);
//        return blogDTOS;
//        --------------------------------------------------
//        List<Blog> blogList = blogRepo.findAll();
//        BlogDTO blogDTO = convertEntityToDto((Blog) blogList);
//        List<BlogDTO> blogDTOList = new ArrayList<>();
//        blogDTOList.add(blogDTO);

        List<BlogDTO> blogDTOList=getAllBlogs();
        return blogDTOList;
    }




    @Override
    public Blog saveBlog(Blog blog, Long userId){

        User u =  userRepo.findByUserId(userId);
        if(u!= null){
//            blog.setUser(u);  edi both side bata one to many and may to one xa bhaney user lai ra blog lai mapping garauna ko lagi
            Blog b1=blogRepo.save(blog);
            List<Blog> blogs = u.getBlogs();
            blogs.add(b1);
//            u.setBlogs(blogs);
            userRepo.save(u);
        }
        return blog;
    }


    public Blog saveBlog(Blog blog){
        return blogRepo.save(blog);

    }



    @Override
    public BlogDTO updateBlog( Blog blog , int blogId){

       Blog currentBlog = blogRepo.findByBlogId(blogId);
       if(blogId==currentBlog.getBlogId()){

           currentBlog.setContent(blog.getContent());
           blogRepo.save(currentBlog);

       }
        return convertEntityToDto(currentBlog);
    }



    @Override
    public Blog deleteBlog(int blogId){
        Blog currentBlog = blogRepo.findByBlogId(blogId);
        blogRepo.delete(currentBlog);
        return currentBlog;
    }

    @Override
    public Blog getSingleBlog(int blogId){

        Blog blog= blogRepo.findByBlogId(blogId);
        return  blog;
    }

    @Override
    public BlogDTO getBlogByBlogId(int blogID){
        return convertEntityToDto(getSingleBlog(blogID));

    }
}
