package site.fish119.adminss.Utils;

import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.domain.sys.Role;

import java.util.List;
import java.util.Set;

public class MainUtil {
    public static List<Menu> cleanChildrenMenu(List<Menu> menus, Set<Role> roles) {
        for (Menu menu : menus) {
            for(Role role : roles) {
                menu.getChildren().removeIf(
                        subMenu -> subMenu.getmRoles().isEmpty() || !subMenu.getmRoles().contains(role)
                );
            }
        }
        return menus;
    }
}
