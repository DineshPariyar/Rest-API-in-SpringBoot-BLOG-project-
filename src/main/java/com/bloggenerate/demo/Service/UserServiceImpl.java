package com.bloggenerate.demo.Service;

import com.bloggenerate.demo.Entity.Blog;
import com.bloggenerate.demo.Entity.Comment;
import com.bloggenerate.demo.Entity.DTO.BlogDTO;
import com.bloggenerate.demo.Entity.DTO.UserDTO;
import com.bloggenerate.demo.Entity.User;
import com.bloggenerate.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    BlogService blogService;

    public List<UserDTO> getUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = convertEntityToDto(user);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }


    private UserDTO convertEntityToDto(User user) {
        List<Blog> blogList = user.getBlogs();
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogDTO blogDTO = blogService.convertEntityToDto(blog);
            blogDTOList.add(blogDTO);
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUserName());
        userDTO.setBlogDTO(blogDTOList);
        return userDTO;

    }

    @Override
    public User findUserByID(long userId){
        return userRepo.findByUserId(userId);
    }


    @Override
    public List<UserDTO> getAllUser() {

        return getUsers();
    }

    @Override
    public User saveUser(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public UserDTO findUser(long userId)
    {
        User u = userRepo.findByUserId(userId);
        return convertEntityToDto(u);
    }

    @Override
    public User deleteUser(long userId) {

        User user = userRepo.findByUserId(userId);
        userRepo.delete(user);
        return user;
    }

    @Override
    public UserDTO updateUser(long userId, User userUpdate) {
//        User user = userRepo.findByUserId(userId);
        Optional<User> userOptional =userRepo.findById(userId);//default findById ley optional return garxa.
        User user = userOptional.orElse(null);
        if (user != null) {
            user.setUserName(userUpdate.getUserName());
            user.setPassword(userUpdate.getPassword());
            user.setAddress(userUpdate.getAddress());
            userRepo.save(user);

        }
        return convertEntityToDto(user);
    }
}
