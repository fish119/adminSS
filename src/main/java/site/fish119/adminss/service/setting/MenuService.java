package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.repository.SysMenuRepository;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private SysMenuRepository menuRepository;

    public List<Menu> findAllMenus() {
        return menuRepository.findByParentMenuIsNullOrderBySortAsc();
    }

    @Transactional
    public Menu saveMenu(Long parentId, Menu subMenu) {
        Menu menu;
        if (parentId != null) {
            menu = menuRepository.findOne(parentId);
            if (subMenu.getId() != null) {
                subMenu.setParentMenu(menu);
                return menuRepository.save(subMenu);
            } else {
                menu.getChildrenMenu().add(subMenu);
                subMenu.setParentMenu(menu);
                return menuRepository.save(menu);
            }
        } else {
            if(subMenu.getChildrenMenu().iterator().hasNext()) {
                Menu trueSubMenu = subMenu.getChildrenMenu().iterator().next();
                trueSubMenu.setParentMenu(subMenu);
                return menuRepository.save(trueSubMenu);
            }else{
                return menuRepository.save(subMenu);
            }
        }
    }

    @Transactional()
    public void delMenu(Long id){
        menuRepository.delete(id);
    }

    @Transactional()
    public void delSubMenu(Long parentId,Long id){
        Menu parentMenu = menuRepository.findOne(parentId);
        Menu menu = menuRepository.findOne(id);
        menu.setParentMenu(null);
        parentMenu.getChildrenMenu().remove(menu);
        menuRepository.delete(menu);
    }
}
