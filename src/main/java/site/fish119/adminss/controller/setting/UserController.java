package site.fish119.adminss.controller.setting;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.service.setting.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/setting/users", method = RequestMethod.GET)
    public ResponseEntity<?> getPageAndSortUsers(
            @RequestParam(name = "searchStr", required = false) String searchStr,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "sortColumn", required = false) String sortColumn,
            @RequestParam(name = "direction", required = false) String direction) {
        Map<String, Object> result = new HashMap<>();
        result.put("data", userService.findUsers(searchStr.trim(), page, size, sortColumn, direction));
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/users", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody JSONObject reqBody) {
        Map<String, String> result = new HashMap<>();
        userService.save(reqBody.getObject("user", User.class));
        result.put("data", "SUCCESS");
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/users/setDefaultPassword", method = RequestMethod.POST)
    public ResponseEntity<?> setDefaultPassword(@RequestBody JSONObject reqBody) {
        Map<String, String> result = new HashMap<>();
        userService.setDefaultPassword(reqBody.getLong("id"));
        result.put("data", "SUCCESS");
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        Map<String, String> result = new HashMap<>();
        userService.deleteUser(id);
        result.put("data", "SUCCESS");
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/user/{id}/phone/{phone}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByPhone(@PathVariable("id") Long id,@PathVariable("phone") String phone) {
        Map<String, Boolean> result = new HashMap<>();
        result.put("data", userService.testUniquePhone(phone,id));
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/user/{id}/username/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByUsername(@PathVariable("id") Long id,@PathVariable("username") String username) {
        Map<String, Boolean> result = new HashMap<>();
        result.put("data", userService.testUniqueUsername(username,id));
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/user/{id}/nickname/{nickname}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByNickname(@PathVariable("id") Long id,@PathVariable("nickname") String nickname) {
        Map<String, Boolean> result = new HashMap<>();
        result.put("data", userService.testUniqueNickname(nickname,id));
        return ResponseEntity.ok(result);
    }
}
