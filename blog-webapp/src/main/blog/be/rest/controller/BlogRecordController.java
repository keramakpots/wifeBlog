package blog.be.rest.controller;


import blog.be.entity.BlogRecord;
import blog.be.rest.service.BlogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogRecords")
public class BlogRecordController {
    @Autowired
    private BlogRecordService blogRecordService;

    @GetMapping
    public List<BlogRecord> getAllBlogRecords() {
        return blogRecordService.getAllBlogRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogRecord> getBlogRecordById(@PathVariable Long id) {
        Optional<BlogRecord> blogRecord = blogRecordService.getBlogRecordById(id);
        return blogRecord.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BlogRecord> createBlogRecord(@RequestBody BlogRecord blogRecord) {
        BlogRecord newBlogRecord = blogRecordService.createBlogRecord(blogRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBlogRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogRecord(@PathVariable Long id) {
        blogRecordService.deleteBlogRecord(id);
        return ResponseEntity.noContent().build();
    }
}
