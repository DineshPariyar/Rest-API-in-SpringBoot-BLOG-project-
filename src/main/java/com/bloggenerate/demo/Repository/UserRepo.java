package com.bloggenerate.demo.Repository;

import com.bloggenerate.demo.Entity.DTO.UserDTO;
import com.bloggenerate.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserId(long userId);

}
