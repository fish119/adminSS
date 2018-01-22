package site.fish119.adminss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.fish119.adminss.domain.sys.Department;

import java.util.List;

public interface SysDepartmentRepository extends JpaRepository<Department,Long>{
    List<Department> findByParentIsNullOrderBySortAsc();
}
