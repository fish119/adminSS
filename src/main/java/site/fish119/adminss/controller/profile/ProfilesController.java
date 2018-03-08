package site.fish119.adminss.controller.profile;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.fish119.adminss.service.setting.DepartService;
import site.fish119.adminss.service.setting.RoleService;
import site.fish119.adminss.service.setting.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProfilesController {
    @Autowired
    public ProfilesController(UserService userService, DepartService departService, RoleService roleService) {
        this.userService = userService;
        this.departService = departService;
        this.roleService = roleService;
    }

    private final UserService userService;
    private final DepartService departService;
    private final RoleService roleService;

    @RequestMapping(value = "/setting/profile", method = RequestMethod.GET)
    public ResponseEntity<?> getProfile() {
        Map<String, Object> result = new HashMap<>();
        result.put("user", userService.findCurrentUser());
        result.put("departments", departService.findAll());
        result.put("roles", roleService.findAll());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/profile/setAvatar", method = RequestMethod.POST)
    public ResponseEntity<?> setAvatar(@RequestParam("avatar") MultipartFile avatar) throws IOException {
        Map<String, String> result = new HashMap<>();
        if (!avatar.isEmpty()) {
            result.put("data", userService.changeAvatar(avatar));
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/profile/changePassword", method = RequestMethod.POST)
    public ResponseEntity<?> changePassword(@RequestBody JSONObject reqBody) {
        Map<String, String> result = new HashMap<>();
        String oldPassword = reqBody.getString("oldPassword");
        String newPassword = reqBody.getString("newPassword");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        userService.changePassword(username, oldPassword, newPassword);
        result.put("data", "SUCCESS");
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(java.io.IOException.class)
    public ResponseEntity<?> handleStorageException(IOException exc) {
        exc.printStackTrace();
        LoggerFactory.getLogger(this.getClass()).error(exc.getLocalizedMessage());
        return ResponseEntity.status(500).build();
    }
}
