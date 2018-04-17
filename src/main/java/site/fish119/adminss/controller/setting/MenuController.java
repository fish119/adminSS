package site.fish119.adminss.controller.setting;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.service.setting.MenuService;

import java.util.*;

@RestController
public class MenuController {
    @Autowired
    public MenuController(MenuService settingService) {
        this.settingService = settingService;
    }

    private final MenuService settingService;

    @RequestMapping(value = "/setting/menus", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMenus() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", settingService.findAllMenus());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/menus", method = RequestMethod.POST)
    public ResponseEntity<?> saveMenu(@RequestBody JSONObject reqBody) {
        Map<String, Object> result = new HashMap<>();
        settingService.saveMenu(reqBody.getLong("parentId"), reqBody.getObject("menu", Menu.class));
        //由于下一句的getCurrentUserMenus()方法会更改本具所获得的结果
        //因此调用service的getNewCopyMenuList方法，重新生成结果数组并返回给客户端
        result.put("data", settingService.getNewCopyMenuList(settingService.findAllMenus()));
        result.put("userMenus", settingService.getCurrentUserMenus());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/menu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delMenu(@PathVariable("id") long id) {
        Map<String, Object> result = new HashMap<>();
        settingService.delMenu(id);
        //由于下一句的getCurrentUserMenus()方法会更改本具所获得的结果
        //因此调用service的getNewCopyMenuList方法，重新生成结果数组并返回给客户端
        result.put("data", settingService.getNewCopyMenuList(settingService.findAllMenus()));
        result.put("userMenus", settingService.getCurrentUserMenus());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/menus/{parentId}/menus/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delSubMenu(@PathVariable("parentId") long parentId, @PathVariable("id") long id) {
        Map<String, Object> result = new HashMap<>();
        settingService.delSubMenu(parentId, id);
        //由于下一句的getCurrentUserMenus()方法会更改本具所获得的结果
        //因此调用service的getNewCopyMenuList方法，重新生成结果数组并返回给客户端
        result.put("data", settingService.getNewCopyMenuList(settingService.findAllMenus()));
        result.put("userMenus", settingService.getCurrentUserMenus());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/currentUserMenus", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentUserMenus() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", settingService.getCurrentUserMenus());
        return ResponseEntity.ok(result);
    }
}
