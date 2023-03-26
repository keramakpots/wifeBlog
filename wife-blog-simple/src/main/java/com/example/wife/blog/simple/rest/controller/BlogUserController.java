package com.example.wife.blog.simple.rest.controller;


import com.example.wife.blog.simple.entity.BlogUser;
import com.example.wife.blog.simple.rest.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogUsers")
public class BlogUserController {
    @Autowired
    private BlogUserService blogUserService;

    @GetMapping
    public List<BlogUser> getAllBlogUsers() {
        return blogUserService.getAllBlogUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogUser> getBlogUserById(@PathVariable Long id) {
        Optional<BlogUser> blogUser = blogUserService.getBlogUserById(id);
        return blogUser.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BlogUser> createBlogUser(@RequestBody BlogUser blogUser) {
        BlogUser newBlogUser = blogUserService.createBlogUser(blogUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBlogUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogUser(@PathVariable Long id) {
        blogUserService.deleteBlogUser(id);
        return ResponseEntity.noContent().build();
    }
}
