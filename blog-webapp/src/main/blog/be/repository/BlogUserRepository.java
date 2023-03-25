package blog.be.repository;

import blog.be.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {
    BlogUser findByUserName(String userName);
}
