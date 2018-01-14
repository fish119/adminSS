package site.fish119.adminss.service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import site.fish119.adminss.repository.SysUserRepository;
import site.fish119.adminss.secruity.UserDetailsImple;
import site.fish119.adminss.secruity.UserDetailsServiceImple;

import java.util.HashMap;
import java.util.Map;

@Service
public class MainService {
    @Autowired
    SysUserRepository userRepository;

    public Map<String, Object> getIndexData() {
        Map<String, Object> result = new HashMap<>();
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            UserDetailsImple user = (UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            result.put("user", userRepository.findByUsername(user.getUsername()));
        } else {
            throw new BadCredentialsException("用户未登录");
        }
        return result;
    }
}
