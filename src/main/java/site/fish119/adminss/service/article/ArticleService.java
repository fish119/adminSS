package site.fish119.adminss.service.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.fish119.adminss.domain.article.Article;
import site.fish119.adminss.domain.article.Category;
import site.fish119.adminss.repository.article.ArticleRepository;
import site.fish119.adminss.repository.article.CategoryRepository;
import site.fish119.adminss.repository.sys.SysUserRepository;
import site.fish119.adminss.secruity.UserDetailsImple;
import site.fish119.adminss.utils.MainUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    SysUserRepository userRepository;

    @Value("${web.upload-path}")
    private String uploadPath;

    public List<Category> findAllCategories() {
        categoryRepository.flush();
        return categoryRepository.findByParentIsNullOrderBySortAsc();
    }

    @Transactional
    public void saveCategory(Long parentId, Category category) {
        Category dbCategory = category.getId() == null ? category : categoryRepository.findOne(category.getId());
        Category oldParent = dbCategory.getParent();
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
            dbCategory.setParent(null);
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

    public Iterable<Article> findArticles(Long id, String searchStr, Integer page, Integer size, String sortColumn, String direction) {
        Pageable pageable = MainUtil.getPageRequest(page, size, sortColumn, direction);
        if(id==null){
            return articleRepository.findByTitleIgnoreCaseContains(searchStr,pageable);
        }else {
            return articleRepository.findByCategory_IdAndTitleIgnoreCaseContains(id, searchStr, pageable);
        }
    }

    @Transactional
    public String saveImage(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID() + ".png";
        Files.copy(file.getInputStream(), Paths.get(uploadPath + "article/").resolve(filename),
                StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    @Transactional
    public Article saveArticle(Long categoryId, Article article) {
        String username = ((UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        article.setAuthor(userRepository.findByUsername(username));
        article.setCategory(categoryRepository.findOne(categoryId));
        return articleRepository.save(article);
    }

    @Transactional
    public void delArticle(Long id){
        articleRepository.delete(id);
    }
}
