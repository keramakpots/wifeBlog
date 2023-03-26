package com.example.wife.blog.simple.repository;

import com.example.wife.blog.simple.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {
    BlogUser findByUserName(String userName);

    BlogUser save(BlogUser blogUser);

    Optional<BlogUser> findById(Long id);

    void deleteById(Long id);
}
