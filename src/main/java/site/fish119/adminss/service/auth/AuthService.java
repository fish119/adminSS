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
import site.fish119.adminss.domain.SysUser;
import site.fish119.adminss.repository.SysRoleRepository;
import site.fish119.adminss.repository.SysUserRepository;
import site.fish119.adminss.secruity.AuthConstant;
import site.fish119.adminss.secruity.AuthRequest;
import site.fish119.adminss.secruity.TokenUtil;
import site.fish119.adminss.secruity.UserDetailsImple;

import java.util.Date;

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
        final String token = tokenUtil.generateToken(userDetails);
        return token;
    }

    public SysUser register(AuthRequest requestUser) {
        final String username = requestUser.getUsername();
        if(userRepository.findByUsername(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = requestUser.getPassword();
        SysUser userToAdd = new SysUser();
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

    public SysUser registerAdmin(AuthRequest requestUser) {
        final String username = requestUser.getUsername();
        if(userRepository.findByUsername(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = requestUser.getPassword();
        SysUser userToAdd = new SysUser();
        userToAdd.setUsername(username);
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        userToAdd.setRoles(roleRepository.findAll());
        return userRepository.save(userToAdd);
    }
}
