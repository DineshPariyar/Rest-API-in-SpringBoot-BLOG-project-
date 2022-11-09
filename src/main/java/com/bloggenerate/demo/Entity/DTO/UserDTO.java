package com.bloggenerate.demo.Entity.DTO;

import java.util.List;

public class UserDTO {

    private long userId;
    private String userName;

    private List<BlogDTO> blogDTO;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public List<BlogDTO> getBlogDTO() {
        return blogDTO;
    }

    public void setBlogDTO(List<BlogDTO> blogDTO) {
        this.blogDTO = blogDTO;
    }
}
