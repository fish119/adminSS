package site.fish119.adminss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.fish119.adminss.domain.SysUser;
import site.fish119.adminss.repository.SysUserRepository;

@RestController
//@Api(description = "Test", name = "Test")
public class TestController {
    @Autowired
    SysUserRepository userRepository;

    @RequestMapping(value = "/test/admin", method = RequestMethod.POST)
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @ApiMethod
//    @ApiAuthToken
    public ResponseEntity<?> test() {
        SysUser u = userRepository.findOne(new Long(15));
        u.setUsername(u.getUsername()+"1");
        return ResponseEntity.ok(userRepository.save(u));
    }

//    @ApiMethod
//    @ApiAuthToken
    @RequestMapping(value = "/test/test", method = RequestMethod.POST)
    public ResponseEntity<?> test2(){
        return  ResponseEntity.ok("OK");
    }
}
