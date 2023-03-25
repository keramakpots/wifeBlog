package blog.be.rest.service;

import blog.be.entity.BlogRecord;
import blog.be.repository.BlogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogRecordService {
    @Autowired
    private BlogRecordRepository blogRecordRepository;

    @Transactional
    public BlogRecord createBlogRecord(BlogRecord blogRecord) {
        return blogRecordRepository.save(blogRecord);
    }

    @Transactional(readOnly = true)
    public List<BlogRecord> getAllBlogRecords() {
        return blogRecordRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<BlogRecord> getBlogRecordById(Long id) {
        return blogRecordRepository.findById(id);
    }

    @Transactional
    public void deleteBlogRecord(Long id) {
        blogRecordRepository.deleteById(id);
    }
}

