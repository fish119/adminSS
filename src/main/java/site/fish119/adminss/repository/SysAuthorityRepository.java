package site.fish119.adminss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.sys.Authority;

import java.util.List;

@Repository
public interface SysAuthorityRepository extends JpaRepository<Authority,Long> {
    List<Authority> findByParentIsNullOrderBySortAsc();
}
