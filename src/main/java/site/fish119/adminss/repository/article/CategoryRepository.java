package site.fish119.adminss.repository.article;

import org.springframework.data.jpa.repository.JpaRepository;
import site.fish119.adminss.domain.article.Category;

import java.util.List;

/**
 * @Project adminss
 * @Package site.fish119.adminss.repository.Article
 * @Author fish119
 * @Date 2018/1/29 10:55
 * @Version V1.0
 */
public interface CategoryRepository extends JpaRepository<Category,Long>{

    List<Category> findByParentIsNullOrderBySortAsc();
}
