package site.fish119.adminss.service.setting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.fish119.adminss.Utils.MainUtil;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.SysUserRepository;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
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
}
