package site.fish119.adminss.secruity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.sys.SysUserRepository;

@Service
public class UserDetailsServiceImple implements UserDetailsService {
//    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException(String.format("用户不存在 '%s'.", s));
        }else{
            return new UserDetailsImple(user);
        }
    }
}
