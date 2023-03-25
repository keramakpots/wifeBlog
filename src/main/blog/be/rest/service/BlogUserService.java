package blog.be.rest.service;


import blog.be.entity.BlogUser;
import blog.be.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogUserService {
    @Autowired
    private BlogUserRepository blogUserRepository;

    @Transactional
    public BlogUser createBlogUser(BlogUser blogUser) {
        return blogUserRepository.save(blogUser);
    }

    @Transactional(readOnly = true)
    public List<BlogUser> getAllBlogUsers() {
        return blogUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<BlogUser> getBlogUserById(Long id) {
        return blogUserRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public BlogUser getBlogUserByUserName(String userName) {
        return blogUserRepository.findByUserName(userName);
    }

    @Transactional
    public void deleteBlogUser(Long id) {
        blogUserRepository.deleteById(id);
    }
}