package site.fish119.adminss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.sys.Menu;
import site.fish119.adminss.domain.sys.Role;

import java.util.List;
import java.util.Set;

@Repository
public interface SysMenuRepository extends JpaRepository<Menu,Long>{
    List<Menu> findByMRolesAndParentIsNullOrderBySortAsc(final Set<Role> roles);
    List<Menu> findByParentIsNullOrderBySortAsc();
}
