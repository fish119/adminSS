package site.fish119.adminss.controller.setting;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fish119.adminss.domain.sys.Department;
import site.fish119.adminss.service.setting.DepartService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DepartController {
    @Autowired
    public DepartController(DepartService departService) {
        this.departService = departService;
    }

    private final DepartService departService;

    @RequestMapping(value = "/setting/departments", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDepartments() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", departService.findAll());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/departments", method = RequestMethod.POST)
    public ResponseEntity<?> saveDepartment(@RequestBody JSONObject reqBody) {
        Map<String, Object> result = new HashMap<>();
        departService.save(reqBody.getLong("parentId"), reqBody.getObject("department", Department.class));
        result.put("data", departService.findAll());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/setting/department/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delDepartment(@PathVariable("id") long id) {
        Map<String, Object> result = new HashMap<>();
        departService.del(id);
        result.put("data", departService.findAll());
        return ResponseEntity.ok(result);
    }
}
