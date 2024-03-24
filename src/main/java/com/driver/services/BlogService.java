package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        Blog obj = new Blog(title, content);
        User x = userRepository1.findById(userId).get();
        obj.setPub(new Date());
        obj.setUser(x);
        List<Blog> arr = x.getBlogList();
        arr.add(obj);
        //x.setBlogList(arr);
        userRepository1.save(x);

        return obj;
        //create a blog at the current time

    }

    public void deleteBlog(int blogId) {

        blogRepository1.deleteById(blogId);

        //delete blog and corresponding images

    }
}
