package site.fish119.adminss.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.fish119.adminss.domain.SysUser;
import site.fish119.adminss.secruity.AuthRequest;
import site.fish119.adminss.service.auth.AuthService;

import java.util.HashMap;


@RestController
//@Api(description = "AuthController", name = "AuthController")
public class AuthController {
    @Autowired
    AuthService service;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        final String token = service.login(authRequest.getUsername(),authRequest.getPassword());
        HashMap<String,String> map = new HashMap<>();
        map.put("token",token);
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
//    @ApiMethod
    public SysUser register(@RequestBody AuthRequest addedUser){
        return service.register(addedUser);
    }

//    @ApiMethod
    @RequestMapping(value = "/auth/registerAdmin", method = RequestMethod.POST)
    public SysUser registerAdmin(@RequestBody AuthRequest addedUser) {
        return service.registerAdmin(addedUser);
    }
}
