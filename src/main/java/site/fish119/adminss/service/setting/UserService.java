package site.fish119.adminss.service.setting;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.fish119.adminss.domain.sys.QUser;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.sys.SysUserRepository;
import site.fish119.adminss.secruity.UserDetailsImple;
import site.fish119.adminss.utils.Constant;
import site.fish119.adminss.utils.MainUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class UserService {
    private final SysUserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public UserService(SysUserRepository userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @Value("${web.upload-path}")
    private String avatarPath;

    private Iterable<User> findAll(Integer page, Integer size, String sortColumn, String direction) {
        return userRepository.findAll(MainUtil.getPageRequest(page, size, sortColumn, direction));
    }

    public Iterable<User> findUsers(String searchStr, Integer page, Integer size, String sortColumn, String direction) {
        if (searchStr.isEmpty()) {
            return this.findAll(page, size, sortColumn, direction);
        } else {
            QUser qUser = QUser.user;
            Predicate predicate = qUser.username.containsIgnoreCase(searchStr)
                    .or(qUser.nickname.containsIgnoreCase(searchStr))
                    .or(qUser.phone.containsIgnoreCase(searchStr))
                    .or(qUser.email.containsIgnoreCase(searchStr));
            return userRepository.findAll(predicate, MainUtil.getPageRequest(page, size, sortColumn, direction));
        }
    }

    @Transactional
    public void save(User user) {
        if (user.getId() != null && userRepository.findOne(user.getId()) != null) {
            User dbUser = userRepository.findOne(user.getId());
            dbUser.setUsername(user.getUsername());
            dbUser.setRoles(user.getRoles());
            dbUser.setDepartment(user.getDepartment());
            dbUser.setEmail(user.getEmail());
            dbUser.setNickname(user.getNickname());
            dbUser.setPhone(user.getPhone());
            userRepository.save(dbUser);
        } else {
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            String result = md5.encodePassword(Constant.DEFAULT_PASSWORD, null);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(result));
            user.setLastPasswordResetDate(new Date());
            userRepository.save(user);
        }
    }

    @Transactional
    public void setDefaultPassword(Long id) {
        User user = userRepository.findOne(id);
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        String result = md5.encodePassword(Constant.DEFAULT_PASSWORD, null);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(result));
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

    public User findCurrentUser() {
        return userRepository.findOne(((UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    @Transactional
    public String changeAvatar(MultipartFile file) throws IOException {
        User user = findCurrentUser();
        String filename = user.getId() + ".png";
        Files.copy(file.getInputStream(), Paths.get(avatarPath + "avatar/").resolve(filename),
                StandardCopyOption.REPLACE_EXISTING);
        user.setAvatar(filename);
        return filename;
    }

    @Transactional
    public void changePassword(String username, String oldPassword, String newPassword) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, oldPassword);
        authenticationManager.authenticate(upToken);
        User user = userRepository.findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(newPassword));
        user.setLastPasswordResetDate(new Date());
        userRepository.save(user);
    }
}
