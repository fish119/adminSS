package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.sys.Department;
import site.fish119.adminss.repository.sys.SysDepartmentRepository;

import java.util.List;

@Service
public class DepartService {
    @Autowired
    public DepartService(SysDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    private final SysDepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findByParentIsNullOrderBySortAsc();
    }

    @Transactional
    public void save(Long parentId, Department depart) {
        Department dbDepart = depart.getId() == null ? depart : departmentRepository.findOne(depart.getId());
        if(depart.getId()!=null) {
            dbDepart.setName(depart.getName());
            dbDepart.setSort(depart.getSort());
        }
        dbDepart.setParent(parentId==null?null:departmentRepository.findOne(parentId));
        departmentRepository.save(dbDepart);
    }

    @Transactional
    public void del(Long id) {
        Department dp = departmentRepository.findOne(id);
        if (dp != null) {
            if (dp.getParent() != null) {
                dp.getParent().getChildren().remove(dp);
                departmentRepository.saveAndFlush(dp.getParent());
                dp.setParent(null);
            }
        }
        departmentRepository.delete(id);
    }
}
