package site.fish119.adminss.controller.setting;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fish119.adminss.domain.sys.Role;
import site.fish119.adminss.service.setting.RoleService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/setting/roles", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoles() {
        Map<String, Object> result = new HashMap<>();
        result.put("data",roleService.findAll());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/roles", method = RequestMethod.POST)
    public ResponseEntity<?> saveRole(@RequestBody JSONObject reqBody){
        Map<String, Object> result = new HashMap<>();
        roleService.save(reqBody.getObject("role",Role.class));
        result.put("data",roleService.findAll());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/role/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delRole(@PathVariable("id") long id){
        Map<String, Object> result = new HashMap<>();
        roleService.delRole(id);
        result.put("data",roleService.findAll());
        return ResponseEntity.ok(result);
    }
}
