package site.fish119.adminss.controller.setting;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fish119.adminss.domain.sys.Authority;
import site.fish119.adminss.service.setting.AuthorityService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthorityController {
    @Autowired public AuthorityController(AuthorityService authorityService){
        this.authorityService = authorityService;
    }
    private final AuthorityService authorityService;

    @RequestMapping(value = "/setting/authorities", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAuthority() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", authorityService.findAllAuthority());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/authorities", method = RequestMethod.POST)
    public ResponseEntity<?> saveMenu(@RequestBody JSONObject reqBody) {
        Map<String, Object> result = new HashMap<>();
        authorityService.saveAuthority(reqBody.getLong("parentId"), reqBody.getObject("authority", Authority.class));
        result.put("data", authorityService.findAllAuthority());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/authority/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delMenu(@PathVariable("id") long id) {
        Map<String, Object> result = new HashMap<>();
        authorityService.delAuthority(id);
        result.put("data", authorityService.findAllAuthority());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/authorities/{parentId}/authorities/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delSubMenu(@PathVariable("parentId") long parentId, @PathVariable("id") long id) {
        Map<String, Object> result = new HashMap<>();
        authorityService.delSubAuthority(parentId, id);
        result.put("data", authorityService.findAllAuthority());
        return ResponseEntity.ok(result);
    }
}
