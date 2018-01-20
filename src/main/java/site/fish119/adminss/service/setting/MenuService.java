package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.Utils.MainUtil;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.SysMenuRepository;
import site.fish119.adminss.repository.SysUserRepository;
import site.fish119.adminss.secruity.UserDetailsImple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MenuService {
    @Autowired
    private SysMenuRepository menuRepository;

    @Autowired
    private SysUserRepository userRepository;

    public List<Menu> findAllMenus() {
        return menuRepository.findByParentIsNullOrderBySortAsc();
    }

    @Transactional
    public void saveMenu(Long parentId, Menu menu) {
        Menu parentMenu;
        if (menu.getId() != null) {
            Menu dbMenu = menuRepository.findOne(menu.getId());
            dbMenu.setAction(menu.getAction());
            dbMenu.setIcon(menu.getIcon());
            dbMenu.setSort(menu.getSort());
            dbMenu.setTitle(menu.getTitle());
            if (parentId != null) {
                parentMenu = menuRepository.findOne(parentId);
                if (dbMenu.getParent() != null) {
                    Menu oldParent = menuRepository.findOne(dbMenu.getParent().getId());
                    oldParent.getChildren().remove(dbMenu);
                    menuRepository.save(oldParent);
                }
                dbMenu.setParent(parentMenu);
                parentMenu.getChildren().add(dbMenu);
                menuRepository.save(parentMenu);
            } else {
                if (dbMenu.getParent() != null) {
                    Menu oldParent = menuRepository.findOne(dbMenu.getParent().getId());
                    oldParent.getChildren().remove(menuRepository.findOne(menu.getId()));
                    menuRepository.save(oldParent);
                }
                dbMenu.setParent(null);
                menuRepository.save(dbMenu);
            }
        } else {
            if (parentId != null) {
                parentMenu = menuRepository.findOne(parentId);
                if (parentMenu.getChildren().isEmpty()) {
                    Set<Menu> set = new HashSet<>();
                    set.add(menu);
                    parentMenu.setChildren(set);
                } else {
                    parentMenu.getChildren().add(menu);
                }
                menu.setParent(parentMenu);
                menuRepository.save(parentMenu);
            } else {
                menuRepository.save(menu);
            }
        }
    }

    @Transactional()
    public void delMenu(Long id) {
        menuRepository.delete(id);
    }

    @Transactional()
    public void delSubMenu(Long parentId, Long id) {
        Menu parentMenu = menuRepository.findOne(parentId);
        Menu menu = menuRepository.findOne(id);
        menu.setParent(null);
        parentMenu.getChildren().remove(menu);
        menuRepository.delete(menu);
    }

    public List<Menu> getCurrentUserMenus() {
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            UserDetailsImple userDetails = (UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByUsername(userDetails.getUsername());
            return MainUtil.cleanChildrenMenu(menuRepository.findByMRolesAndParentIsNullOrderBySortAsc(user.getRoles()), user.getRoles());
        } else {
            throw new BadCredentialsException("用户未登录");
        }
    }
}
