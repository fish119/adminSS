package site.fish119.adminss.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.sys.SysRoleRepository;
import site.fish119.adminss.repository.sys.SysUserRepository;
import site.fish119.adminss.security.AuthConstant;
import site.fish119.adminss.security.AuthRequest;
import site.fish119.adminss.security.TokenUtil;
import site.fish119.adminss.security.UserDetailsImple;

import java.util.Date;
import java.util.HashSet;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SysUserRepository userRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    SysRoleRepository roleRepository;

    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return tokenUtil.generateToken(userDetails);
    }

    public User register(AuthRequest requestUser) {
        final String username = requestUser.getUsername();
        if(userRepository.findByUsername(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = requestUser.getPassword();
        User userToAdd = new User();
        userToAdd.setUsername(username);
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        return userRepository.save(userToAdd);
    }

    public String refresh(String oldToken) {
        final String token = oldToken.substring(AuthConstant.tokenPrefix.length());
        String username = tokenUtil.getUsernameFromToken(token);
        UserDetailsImple user = (UserDetailsImple)userDetailsService.loadUserByUsername(username);
        if (tokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return tokenUtil.refreshToken(token);
        }
        return null;
    }

    public User registerAdmin(AuthRequest requestUser) {
        final String username = requestUser.getUsername();
        if(userRepository.findByUsername(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = requestUser.getPassword();
        User userToAdd = new User();
        userToAdd.setUsername(username);
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        userToAdd.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(userToAdd);
    }
}
