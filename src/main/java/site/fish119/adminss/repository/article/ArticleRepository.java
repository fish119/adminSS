package site.fish119.adminss.repository.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.article.Article;

/**
 * @Project adminss
 * @Package site.fish119.adminss.repository.Article
 * @Author fish119
 * @Date 2018/1/29 10:54
 * @Version V1.0
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    Page<Article> findByCategory_IdAndTitleIgnoreCaseContains(Long id, String title, Pageable pageable);
    Page<Article> findByTitleIgnoreCaseContains(String title, Pageable pageable);
}
