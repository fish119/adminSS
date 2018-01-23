package site.fish119.adminss.controller.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
//        LoggerFactory.getLogger("searchStr"+this.getClass()).info(searchStr);
        Map<String, Object> result = new HashMap<>();
        result.put("data", userService.findUsers(searchStr.trim(), page, size, sortColumn, direction));
        return ResponseEntity.ok(result);
    }
}
