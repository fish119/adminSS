package site.fish119.adminss.controller.setting;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.service.setting.MenuService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MenuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MenuService settingService;

    @RequestMapping(value = "/setting/menus", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMenus() {
        Map<String, Object> result = new HashMap<>();
        result.put("data",settingService.findAllMenus());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/menus", method = RequestMethod.POST)
    public ResponseEntity<?> saveMenu(@RequestBody JSONObject reqBody){
        Map<String, Object> result = new HashMap<>();
        settingService.saveMenu(reqBody.getLong("parentId"),reqBody.getObject("menu",Menu.class));
        result.put("data",settingService.findAllMenus());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/menu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delMenu(@PathVariable("id") long id){
        Map<String, Object> result = new HashMap<>();
        settingService.delMenu(id);
        result.put("data",settingService.findAllMenus());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/menus/{parentId}/menus/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delSubMenu(@PathVariable("parentId") long parentId,@PathVariable("id") long id){
        Map<String, Object> result = new HashMap<>();
        settingService.delSubMenu(parentId,id);
        result.put("data",settingService.findAllMenus());
        return ResponseEntity.ok(result);
    }
}
