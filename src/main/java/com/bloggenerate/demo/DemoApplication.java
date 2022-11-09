package com.bloggenerate.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

/*{
        "userId":1,
        "userName":"xxxxx",
        "password":"xxxxx",
        "address":{
        "addressId":1,
        "country":"Nepal",
        "state":2,
        "city":"Kathmandu"
        },
        "blog":{
        "blogId":1,
        "content":"this is my first Blog",
        "comment":{
        "commentId":1,
        "comments":"first Comment"
        }
        }
        }

 */
