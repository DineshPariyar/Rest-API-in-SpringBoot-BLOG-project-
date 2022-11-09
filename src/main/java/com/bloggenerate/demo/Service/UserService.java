package com.bloggenerate.demo.Service;

import com.bloggenerate.demo.Entity.DTO.UserDTO;
import com.bloggenerate.demo.Entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();

    User saveUser(User user);

    UserDTO findUser(long userId);

    User findUserByID(long userId);

    User deleteUser(long userId);

    UserDTO updateUser(long userId, User userUp);
}
