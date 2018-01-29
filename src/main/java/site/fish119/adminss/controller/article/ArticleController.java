package site.fish119.adminss.controller.article;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fish119.adminss.domain.article.Category;
import site.fish119.adminss.service.article.ArticleService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project adminss
 * @Package site.fish119.adminss.controller.article
 * @Author fish119
 * @Date 2018/1/29 12:12
 * @Version V1.0
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/article/categories", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCategories() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", articleService.findAllCategories());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/article/categories", method = RequestMethod.POST)
    public ResponseEntity<?> saveCategory(@RequestBody JSONObject reqBody) {
        Map<String, Object> result = new HashMap<>();
        articleService.saveCategory(reqBody.getLong("parentId"), reqBody.getObject("category", Category.class));
        result.put("data", articleService.findAllCategories());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/article/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delCategory(@PathVariable("id") long id){
        Map<String, Object> result = new HashMap<>();
        articleService.delCategory(id);
        result.put("data",articleService.findAllCategories());
        return ResponseEntity.ok(result);
    }
}
