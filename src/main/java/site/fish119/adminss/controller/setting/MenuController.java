package site.fish119.adminss.controller.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.fish119.adminss.service.setting.SettingService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MenuController {
    @Autowired
    private SettingService settingService;

    @RequestMapping(value = "/setting/menus", method = RequestMethod.POST)
    public ResponseEntity<?> getAllMenus() {
        Map<String, Object> result = new HashMap<>();
        result.put("data",settingService.findAllMenus());
        return ResponseEntity.ok(result);
    }
}
