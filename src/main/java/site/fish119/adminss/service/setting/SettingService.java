package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.repository.SysMenuRepository;

import java.util.List;

@Service
public class SettingService {
    @Autowired
    private SysMenuRepository menuRepository;

    public List<Menu> findAllMenus(){
        return menuRepository.findByParentMenuIsNullOrderBySortAsc();
    }
}
