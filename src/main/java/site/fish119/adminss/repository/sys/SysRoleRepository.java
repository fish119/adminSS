package site.fish119.adminss.repository.sys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.sys.Role;

@Repository
public interface SysRoleRepository extends JpaRepository<Role,Long>{
}
