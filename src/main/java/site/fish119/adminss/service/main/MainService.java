package site.fish119.adminss.service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import site.fish119.adminss.utils.MainUtil;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.sys.SysMenuRepository;
import site.fish119.adminss.repository.sys.SysUserRepository;
import site.fish119.adminss.security.UserDetailsImple;

import java.util.HashMap;
import java.util.Map;

@Service
public class MainService {
//    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysUserRepository userRepository;

    @Autowired
    SysMenuRepository menuRepository;

    public Map<String, Object> getIndexData() {
        Map<String, Object> result = new HashMap<>();
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            UserDetailsImple userDetails = (UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByUsername(userDetails.getUsername());
            result.put("user", user);
            result.put("menus", MainUtil.cleanChildrenMenu(menuRepository.findByMRolesAndParentIsNullOrderBySortAsc(user.getRoles()), user.getRoles()));
        } else {
            throw new BadCredentialsException("用户未登录");
        }
        return result;
    }
}
