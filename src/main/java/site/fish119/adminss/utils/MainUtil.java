package site.fish119.adminss.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.domain.sys.Role;

import java.util.List;
import java.util.Set;

public class MainUtil {
    public static List<Menu> cleanChildrenMenu(List<Menu> menus, Set<Role> roles) {
        for (Menu menu : menus) {
            for (Role role : roles) {
                menu.getChildren().removeIf(
                        subMenu -> subMenu.getMRoles().isEmpty() || !subMenu.getMRoles().contains(role)
                );
            }
        }
        return menus;
    }

    private static Sort getSort(String sortColumn, String direction) {
        Sort.Direction dr = Sort.Direction.ASC;
        if (direction != null && direction.equals("DESC")) dr = Sort.Direction.DESC;
        if (sortColumn == null) sortColumn = "username";
        return new Sort(dr, sortColumn);
    }

    public static Pageable getPageRequest(Integer page, Integer size, String sortColumn, String direction) {
        return new PageRequest(page == null ? 0 : page, size == null || size <= 1 ? 50 : size, getSort(sortColumn, direction));
    }
}
