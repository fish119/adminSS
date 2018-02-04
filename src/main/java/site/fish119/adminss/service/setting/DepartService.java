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
    private SysDepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findByParentIsNullOrderBySortAsc();
    }

    @Transactional
    public void save(Long parentId, Department depart) {
        Department dbDepartment = depart.getId() == null ? depart : departmentRepository.findOne(depart.getId());
        Department oldParent = dbDepartment.getParent();
        if (parentId != null) {
            Department parentDepartment = departmentRepository.findOne(parentId);
            if (oldParent != null && !oldParent.getId().equals(parentId)) {
                dbDepartment.getParent().getChildren().remove(dbDepartment);
                departmentRepository.saveAndFlush(oldParent);
            }
            dbDepartment.setParent(parentDepartment);
            parentDepartment.getChildren().add(dbDepartment);
        } else {
            if (oldParent != null) {
                dbDepartment.getParent().getChildren().remove(dbDepartment);
                departmentRepository.saveAndFlush(oldParent);
            }
            dbDepartment.setParent(null);
        }

        dbDepartment.setName(depart.getName());
        dbDepartment.setSort(depart.getSort());
        departmentRepository.saveAndFlush(dbDepartment);
        if (dbDepartment.getParent() != null) {
            departmentRepository.saveAndFlush(dbDepartment.getParent());
        }
    }

    @Transactional
    public void del(Long id) {
        Department dp = departmentRepository.findOne(id);
        if(dp!=null){
            if(dp.getParent()!=null){
                dp.getParent().getChildren().remove(dp);
                departmentRepository.saveAndFlush(dp.getParent());
                dp.setParent(null);
            }
        }
        departmentRepository.delete(id);
    }
}
