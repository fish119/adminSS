package site.fish119.adminss.controller.profile;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.fish119.adminss.service.setting.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProfilesController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/setting/profile/setAvatar", method = RequestMethod.POST)
    public ResponseEntity<?> setAvatar(@RequestParam("avatar") MultipartFile avatar) throws IOException {
        Map<String, String> result = new HashMap<>();
        if (!avatar.isEmpty()) {
            result.put("data", userService.changeAvatar(avatar));
        }
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(java.io.IOException.class)
    public ResponseEntity<?> handleStorageException(IOException exc) {
        exc.printStackTrace();
        LoggerFactory.getLogger(this.getClass()).error(exc.getLocalizedMessage());
        return ResponseEntity.status(500).build();
    }
}
