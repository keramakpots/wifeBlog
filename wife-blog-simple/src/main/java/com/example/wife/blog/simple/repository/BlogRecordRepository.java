package com.example.wife.blog.simple.repository;

import com.example.wife.blog.simple.entity.BlogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRecordRepository extends JpaRepository<BlogRecord, Long> {
    Optional<BlogRecord> findById(Long id);

    void deleteById(Long id);

    BlogRecord save(BlogRecord blogRecord);
}