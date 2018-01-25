package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.Utils.Constant;
import site.fish119.adminss.Utils.MainUtil;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.SysUserRepository;
import site.fish119.adminss.secruity.UserDetailsImple;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    SysUserRepository userRepository;

    public Iterable<User> findAll(Integer page, Integer size, String sortColumn, String direction) {
        return userRepository.findAll(MainUtil.getPageRequest(page, size, sortColumn, direction));
    }

    public Iterable<User> findUsers(String searchStr, Integer page, Integer size, String sortColumn, String direction) {
//        LoggerFactory.getLogger(this.getClass()).info(username);
        if (searchStr.isEmpty()) {
            return this.findAll(page, size, sortColumn, direction);
        } else {
            return userRepository.findByUsernameIgnoreCaseContainingOrNicknameIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContaining(searchStr, searchStr, searchStr, searchStr, MainUtil.getPageRequest(page, size, sortColumn, direction));
        }
    }

    @Transactional
    public void save(User user) {
        if (user.getId() != null) {
            User dbUser = userRepository.findOne(user.getId());
            dbUser.setUsername(user.getUsername());
            dbUser.setRoles(user.getRoles());
            dbUser.setDepartment(user.getDepartment());
            dbUser.setEmail(user.getEmail());
            dbUser.setNickname(user.getNickname());
            dbUser.setPhone(user.getPhone());
            userRepository.save(dbUser);
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(Constant.DEFAULT_PASSWORD));
            user.setLastPasswordResetDate(new Date());
            user.setCreateDate(new Date());
            userRepository.save(user);
        }
    }

    @Transactional
    public void setDefaultPassword(Long id) {
        User user = userRepository.findOne(id);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(Constant.DEFAULT_PASSWORD));
        user.setLastPasswordResetDate(new Date());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public boolean testUniquePhone(String phone, Long id) {
        return userRepository.findFirstByPhoneAndIdNot(phone, id) == null;
    }

    public boolean testUniqueUsername(String username, Long id) {
        return userRepository.findFirstByUsernameAndIdNot(username, id) == null;
    }

    public boolean testUniqueNickname(String nickname, Long id) {
        return userRepository.findFirstByNicknameAndIdNot(nickname, id) == null;
    }

    public boolean testUniqueEmail(String email, Long id) {
        return userRepository.findFirstByEmailAndIdNot(email, id) == null;
    }

    public User findCurrentUser(){
        return userRepository.findOne(((UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
