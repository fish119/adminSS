package site.fish119.adminss.service.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.article.Category;
import site.fish119.adminss.repository.article.CategoryRepository;

import java.util.Date;
import java.util.List;

/**
 * @Project adminss
 * @Package site.fish119.adminss.service.article
 * @Author fish119
 * @Date 2018/1/29 11:33
 * @Version V1.0
 */
@Service
public class ArticleService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findByParentIsNullOrderBySortAsc();
    }

    @Transactional
    public void saveCategory(Long parentId, Category category) {
        Category dbCategory = category.getId() == null ? category : categoryRepository.findOne(category.getId());
        Category oldParent = dbCategory.getParent();
        if (category.getId() == null) {
            dbCategory.setCreateTime(new Date());
        }
        if (parentId != null) {
            Category parentCategory = categoryRepository.findOne(parentId);
            if (oldParent != null && !oldParent.getId().equals(parentId)) {
                dbCategory.getParent().getChildren().remove(dbCategory);
                categoryRepository.saveAndFlush(oldParent);
            }
            dbCategory.setParent(parentCategory);
            parentCategory.getChildren().add(dbCategory);
        } else {
            if (oldParent != null) {
                dbCategory.getParent().getChildren().remove(dbCategory);
                categoryRepository.saveAndFlush(oldParent);
            }
        }

        dbCategory.setName(category.getName());
        dbCategory.setSort(category.getSort());
        categoryRepository.saveAndFlush(dbCategory);
        if (dbCategory.getParent() != null) {
            categoryRepository.saveAndFlush(dbCategory.getParent());
        }
    }

    @Transactional
    public void delCategory(Long id) {
        Category dbCategory = categoryRepository.findOne(id);
        if (dbCategory != null && dbCategory.getParent() != null) {
            dbCategory.getParent().getChildren().remove(dbCategory);
            categoryRepository.saveAndFlush(dbCategory.getParent());
            dbCategory.setParent(null);
        }
        categoryRepository.delete(id);
    }
}
