package site.fish119.adminss.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.sys.Role;

@Repository
@CacheConfig(cacheNames = "sysRoles")
@Cacheable
public interface SysRoleRepository extends JpaRepository<Role,Long>{
}
