package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.sys.Department;
import site.fish119.adminss.repository.SysDepartmentRepository;

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
        Department dbDepart = depart.getId() == null ? depart : departmentRepository.findOne(depart.getId());
        Department oldParent = dbDepart.getParent();
        if (parentId != null) {
            Department parentDepart = departmentRepository.findOne(parentId);
            if (oldParent != null && !oldParent.getId().equals(parentId)) {
                dbDepart.getParent().getChildren().remove(dbDepart);
                departmentRepository.saveAndFlush(oldParent);
            }
            dbDepart.setParent(parentDepart);
            parentDepart.getChildren().add(dbDepart);
        } else {
            if (oldParent != null) {
                dbDepart.getParent().getChildren().remove(dbDepart);
                departmentRepository.saveAndFlush(oldParent);
            }
        }

        dbDepart.setName(depart.getName());
        dbDepart.setSort(depart.getSort());
        departmentRepository.saveAndFlush(dbDepart);
        if(dbDepart.getParent()!=null){
            departmentRepository.saveAndFlush(dbDepart.getParent());
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
