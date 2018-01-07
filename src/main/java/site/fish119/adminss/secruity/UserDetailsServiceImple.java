package site.fish119.adminss.secruity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.SysUser;
import site.fish119.adminss.repository.SysUserRepository;

@Service
public class UserDetailsServiceImple implements UserDetailsService {
    @Autowired
    private SysUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", s));
        }else{
            return new UserDetailsImple(user);
        }
    }
}
