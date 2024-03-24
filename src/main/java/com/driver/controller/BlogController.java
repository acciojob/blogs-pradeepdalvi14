package com.driver.controller;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.services.BlogService;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    @PostMapping
    public ResponseEntity createBlog(@RequestParam Integer userId ,
                                     @RequestParam String title,
                                     @RequestParam String content) {
        // Create a blog and add it under given user
        blogService.createAndReturnBlog(userId,title,content);

        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int blogId) {
        // Delete the blog using deleteById
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




