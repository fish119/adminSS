package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.domain.sys.User;
import site.fish119.adminss.repository.sys.SysMenuRepository;
import site.fish119.adminss.repository.sys.SysUserRepository;
import site.fish119.adminss.security.UserDetailsImple;
import site.fish119.adminss.utils.MainUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    public MenuService(SysMenuRepository menuRepository, SysUserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    private final SysMenuRepository menuRepository;

    private final SysUserRepository userRepository;

    public List<Menu> findAllMenus() {
        return menuRepository.findByParentIsNullOrderBySortAsc();
    }

    public List<Menu> getNewCopyMenuList(Iterable<Menu> oldList){
        List<Menu> data= new ArrayList<>();
        for(Menu menu : oldList){
            Menu tmp = new Menu();
            tmp.setAction(menu.getAction());
            tmp.setIcon(menu.getIcon());
            tmp.setTitle(menu.getTitle());
            tmp.setSort(menu.getSort());
            tmp.setId(menu.getId());
            tmp.setChildren(new LinkedHashSet<>(getNewCopyMenuList(menu.getChildren())));
            data.add(tmp);
        }
        return data;
    }

    @Transactional
    public void saveMenu(Long parentId, Menu menu) {
        Menu dbMenu = menu.getId() == null ? menu : menuRepository.findOne(menu.getId());
        if(menu.getId()!=null) {
            dbMenu.setIcon(menu.getIcon());
            dbMenu.setTitle(menu.getTitle());
            dbMenu.setSort(menu.getSort());
            dbMenu.setAction(menu.getAction());
        }
        dbMenu.setParent(parentId==null?null:menuRepository.findOne(parentId));
        menuRepository.save(dbMenu);
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
