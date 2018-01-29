package site.fish119.adminss.controller.article;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.fish119.adminss.domain.article.Category;
import site.fish119.adminss.service.article.ArticleService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @RequestMapping(value = "/article/articles", method = RequestMethod.GET)
    public ResponseEntity<?> getPageAndSortArticlesAndCategories(
            @RequestParam(name = "categoryId", required = false) Long categoryId,
            @RequestParam(name = "searchStr", required = false) String searchStr,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "sortColumn", required = false) String sortColumn,
            @RequestParam(name = "direction", required = false) String direction) {
        Map<String, Object> result = new HashMap<>();
        result.put("articles", articleService.findArticles(categoryId, searchStr, page, size, sortColumn, direction));
        result.put("categories",articleService.findAllCategories());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/article/imageUpload", method = RequestMethod.POST)
    public ResponseEntity<?> setAvatar(HttpServletRequest request, @RequestParam("image") MultipartFile image) throws IOException {
        Map<String, Object> result = new HashMap<>();
        if (!image.isEmpty()) {
            String imgUrl = "http://"+request.getLocalName()+":"+request.getLocalPort();
            imgUrl += "/article/"+articleService.saveImage(image);
            LoggerFactory.getLogger(getClass()).info(imgUrl);
            result.put("data", imgUrl);
            result.put("ok",true);
        }
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(java.io.IOException.class)
    public ResponseEntity<?> handleStorageException(IOException exc) {
        exc.printStackTrace();
        LoggerFactory.getLogger(this.getClass()).error(exc.getLocalizedMessage());
        Map<String, Object> result = new HashMap<>();
        result.put("ok",false);
        result.put("msg",exc.getLocalizedMessage());
        return ResponseEntity.ok(result);
    }
}
