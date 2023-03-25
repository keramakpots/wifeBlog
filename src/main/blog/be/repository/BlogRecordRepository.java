package blog.be.repository;

import blog.be.entity.BlogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRecordRepository extends JpaRepository<BlogRecord, Long> {
}