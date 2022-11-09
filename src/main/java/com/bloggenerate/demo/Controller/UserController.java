package com.bloggenerate.demo.Controller;


import com.bloggenerate.demo.Entity.DTO.UserDTO;
import com.bloggenerate.demo.Entity.User;
import com.bloggenerate.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User savedUser =  userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(savedUser);

    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body( userService.getAllUser());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findUserById(@PathVariable("userId") long userId){
        UserDTO user = userService.findUser(userId);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Retrieved User of Id = " +" " + user.getUserId() +"full Detail "+ user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("user of  id " + userId + " is deleted Successfully");
    }


    @PutMapping("/user/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") long userId, @RequestBody User user){
        UserDTO  user1 = userService.updateUser(userId, user);
        return ResponseEntity.status(HttpStatus.OK).body(user1);

    }















}
